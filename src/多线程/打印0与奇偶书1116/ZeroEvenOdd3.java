package 多线程.打印0与奇偶书1116;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @Package: 多线程.打印0与奇偶书1116
 * @Author: chenyang
 * @Date: 2021/2/24
 * @Version: 1.0
 */
public class ZeroEvenOdd3 implements ZeroEvenOddI {
    private int n;

    public ZeroEvenOdd3(int n) {
        this.n = n;
    }

    private volatile AtomicBoolean zeroFlag = new AtomicBoolean(true);
    private volatile AtomicBoolean evenFlag = new AtomicBoolean(false);
    private volatile AtomicBoolean oddFlag = new AtomicBoolean(false);
    private volatile AtomicInteger sum = new AtomicInteger(0);

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (sum.get() < n) {
            while (!zeroFlag.get()) Thread.yield();
            if (sum.get() >= n) return;
            zeroFlag.set(false);
            printNumber.accept(0);
            if (sum.incrementAndGet() % 2 == 0) {
                evenFlag.set(true);
            } else {
                oddFlag.set(true);
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (sum.get() < n) {
            while (!evenFlag.get()) {
                if(sum.get() >= n) return;
                Thread.yield();
            }
            if (sum.get() > n) return;
            printNumber.accept(sum.get());
            evenFlag.set(false);
            zeroFlag.set(true);
        }


    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (sum.get() < n) {
            while (!oddFlag.get()) {
                if(sum.get() >= n) return;
                Thread.yield();
            }
            if (sum.get() > n) return;
            printNumber.accept(sum.get());
            oddFlag.set(false);
            zeroFlag.set(true);
        }
    }
}
