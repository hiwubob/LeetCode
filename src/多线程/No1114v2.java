package ∂‡œﬂ≥Ã;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class No1114v2 {
    //ReentrantLock + condition
    ReentrantLock lock = new ReentrantLock();
    Condition firstCondition=lock.newCondition();
    Condition secondeCondition=lock.newCondition();
    Condition thirdConditon=lock.newCondition();
    int state=1;
    public No1114v2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            if (state != 1) {
                firstCondition.await();
            }
            state=2;
            printFirst.run();
            secondeCondition.signal();
        }finally {
            lock.unlock();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.

    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.

        lock.lock();
        try {
            if (state != 2) {
                firstCondition.await();
            }
            state=3;
            printSecond.run();
            secondeCondition.signal();
        }finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        lock.lock();
        try {
            if (state != 2) {
                firstCondition.await();
            }
            state=3;
            printThird.run();
            secondeCondition.signal();
        }finally {
            lock.unlock();
        }
    }
}
