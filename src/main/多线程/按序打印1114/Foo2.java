package 多线程.按序打印1114;

public class Foo2 {
    public Foo2() {

    }

    private final Object obj = new Object();
    boolean first = false;
    boolean second = false;

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (obj) {
            printFirst.run();
            first = true;
            obj.notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (obj) {
            while (!first) {
                obj.wait();
            }
            printSecond.run();
            second = true;
            obj.notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (obj) {
            while (!second) {
                obj.wait();
            }
            printThird.run();
        }

    }
}
