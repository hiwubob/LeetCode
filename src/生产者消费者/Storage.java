package 生产者消费者;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {
    private final int MAX_SIZE = 10;
    private LinkedList list = new LinkedList();


    public void produce() {
        synchronized (list) {
            while (list.size() + 1 > MAX_SIZE) {
                System.out.println("【生产者" + Thread.currentThread().getName()
                        + "】仓库已满");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("【生产者" + Thread.currentThread().getName()
                    + "】生产一个产品，现库存" + list.size());
            list.notifyAll();
        }
    }

    public void consume() {
        synchronized (list) {
            while (list.size() == 0) {
                System.out.println("没有产品");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.remove();
            System.out.println("消费一个产品");
            list.notifyAll();
        }
    }

    //lock+condition
    Lock lock = new ReentrantLock();
    Condition full = lock.newCondition();
    Condition empty = lock.newCondition();

    public void produce1() {
        try {
            lock.lock();
            while (list.size() + 1 > MAX_SIZE) {
                System.out.println("已满");
                try {
                    full.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            empty.signal();
        } finally {
            lock.unlock();
        }

    }

    public void consume2() {
        try {
            lock.lock();
            while (list.size() == 0) {
                System.out.println("已空");
                try {
                    empty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.remove();
            full.signal();
        } finally {
            lock.unlock();
        }
    }

    //阻塞队列
    private LinkedBlockingQueue<Object> listbq = new LinkedBlockingQueue<>(10);

    public void produce3() {
        try {
            listbq.put(new Object());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consume3() {
        try {
            listbq.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //信号量
    final Semaphore notFull = new Semaphore(10);
    final Semaphore notEmpty = new Semaphore(0);
    final Semaphore mutex = new Semaphore(1);

    public void produce4() {
        try {
            notFull.acquire();
            mutex.acquire();
            list.add(new Object());
            System.out.println("生成 一个");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mutex.release();
            notEmpty.release();
        }
    }

    public void consume4() {
        try {
            notEmpty.acquire();
            mutex.acquire();
            listbq.remove();
            System.out.println("消费一个");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mutex.release();
            notFull.release();
        }
    }
}
