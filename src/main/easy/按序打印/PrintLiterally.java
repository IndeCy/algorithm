package easy.按序打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintLiterally {

    static ReentrantLock lock = new ReentrantLock();

    static Condition hello = lock.newCondition();
    static Condition world = lock.newCondition();
    static volatile int flag = 0;


    static void testHello() throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    if (flag == 1) {
                        hello.await();
                    }
                    System.out.print("hello ");
                    flag = 1;
                    world.signalAll();
                    lock.unlock();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static void testWorld() throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    if (flag == 0) {
                        world.await();
                    }
                    System.out.println("world!");
                    flag = 0;
                    hello.signalAll();
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        try {
            testHello();
            testWorld();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
