package 多线程.打印0与奇偶书1116;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    private volatile int i = 1;
    private volatile boolean zeroFlag = true;
    private volatile boolean evenFlag = false;
    private volatile boolean oddFlag = true;
    private final Object obj = new Object();
    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        synchronized (obj) {
            while (i <= n) {
                if (!zeroFlag) {
                    obj.wait();
                }
                if(i <= n) {
                    printNumber.accept(0);
                }
                zeroFlag = false;
                obj.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        synchronized (obj) {
            while(i <= n) {
                if(!evenFlag || zeroFlag){
                    obj.wait();
                }
                if(i <= n) {
                    printNumber.accept(i++);
                }
                zeroFlag = true;
                evenFlag = false;
                oddFlag = true;
                obj.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        synchronized (obj) {
            while(i <= n){
                if(!oddFlag || zeroFlag){
                    obj.wait();
                }
                if(i <= n) {
                    printNumber.accept(i++);
                }
                oddFlag = false;
                evenFlag = true;
                zeroFlag = true;
                obj.notifyAll();
            }
        }
    }
}
