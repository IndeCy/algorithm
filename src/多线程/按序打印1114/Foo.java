package 多线程.按序打印1114;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Foo {

    public Foo() {

    }

    ReentrantLock lock = new ReentrantLock();
    Condition one = lock.newCondition();
    Condition two = lock.newCondition();
    boolean first = false;
    boolean second = false;

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        lock.lock();
        printFirst.run();
        first = true;
        one.signal();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        lock.lock();
        while(!first){
            one.await();
        }
        printSecond.run();
        two.signal();
        second = true;
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        lock.lock();
        while(!second){
            two.await();
        }
        printThird.run();
        lock.unlock();
    }
}
