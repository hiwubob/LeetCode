package consumerproduct;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class blockqueue {
    //阻塞队列
    Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    final int MAX = 10;
    List list = new LinkedList<>();

    public void put() {
        try {
            lock.lock();
            while (list.size() + 1 > MAX) {
                notEmpty.await();
            }

            list.add(new Object());
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void take() {
        try {
            lock.lock();
            while (list.size() == 0) {
                notFull.await();
            }
            list.remove(list.size()-1);
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}