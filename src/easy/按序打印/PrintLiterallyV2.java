package easy.按序打印;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintLiterallyV2 {

    static AtomicInteger FLAG = new AtomicInteger(0);

    static void testHello() {
        for (int i = 0; i < 10; ) {
            if (FLAG.get() % 3 == 0) {
                System.out.print("Hello ");
                i++;
                FLAG.getAndIncrement();
            }
        }
    }

    static void testWorld() {
        for (int i = 0; i < 10; ) {
            if (FLAG.get() % 3 == 1) {
                System.out.print("world ");
                i++;
                FLAG.getAndIncrement();
            }
        }
    }

    static void testJava() {
        for (int i = 0; i < 10; ) {
            if (FLAG.get() % 3 == 2) {
                System.out.println("java! ");
                i++;
                FLAG.getAndIncrement();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(PrintLiterallyV2::testHello);
        thread.start();
        Thread thread1 = new Thread(PrintLiterallyV2::testWorld);
        thread1.start();
        Thread thread2 = new Thread(PrintLiterallyV2::testJava);
        thread2.start();
        thread.join();
        thread1.join();
        thread2.join();
        System.out.println(FLAG.get());
//        List<Thread> a = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(PrintLiterallyV2::testHello);
//            Thread thread1 = new Thread(PrintLiterallyV2::testWorld);
//            thread.start();
//            thread1.start();
//            a.add(thread);
//            a.add(thread1);
//        }
//        a.forEach(s -> {
//            try {
//                s.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });

    }
}
