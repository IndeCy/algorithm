package easy.按序打印;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintLiterallyV3 {

    public static void main(String[] args) {
        Object o = new Object();
        AtomicInteger a = new AtomicInteger(0);
        new Thread(() -> {
            for (int i = 0; i < 10;) {
                synchronized (o){
                    if(a.get() % 2 == 0) {
                        System.out.print("hello ");
                        a.getAndIncrement();
                        o.notifyAll();
                        i++;
                    }else {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < 10;) {
                synchronized (o) {
                    if(a.get() % 2 != 0) {
                        System.out.println("world!!");
                        a.getAndIncrement();
                        o.notifyAll();
                        i++;
                    }else {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

    }
}
