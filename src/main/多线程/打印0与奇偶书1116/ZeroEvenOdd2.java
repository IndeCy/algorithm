package 多线程.打印0与奇偶书1116;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd2 {

    private int n;

    public ZeroEvenOdd2(int n) {
        this.n = n;
    }

    private volatile int i = 1;
    private volatile boolean zeroFlag = true;
    Lock lock = new ReentrantLock();
    Condition zeroC = lock.newCondition();
    Condition evenC = lock.newCondition();
    Condition oddC = lock.newCondition();
    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        try {
            lock.lock();
            while (i <= n) {
                if (!zeroFlag) {
                    zeroC.await();
                }
                if (i <= n) {
                    printNumber.accept(0);
                }
                zeroFlag = false;
                if (i % 2 == 0) {
                    evenC.signal();
                } else {
                    oddC.signal();
                }
            }
        }finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        try{
            lock.lock();
            while(i <= n) {
                if(i % 2 != 0 || zeroFlag){
                    evenC.await();
                }
                if(i <= n) {
                    printNumber.accept(i++);
                    zeroFlag = true;
                }
                zeroC.signal();
            }
        }finally {

            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        try {
            lock.lock();
            while (i <= n) {
                if (i % 2 == 0 || zeroFlag) {
                    oddC.await();
                }
                if (i <= n) {
                    printNumber.accept(i++);
                    zeroFlag = true;
                }
                zeroC.signal();
            }
        }finally {
            lock.unlock();
        }
    }
}
