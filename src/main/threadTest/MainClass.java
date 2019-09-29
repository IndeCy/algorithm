package threadTest;

import java.util.HashMap;
import java.util.Map;

public class MainClass {

    public static void main(String[] args) {

       /* Map a = new HashMap();
        a.put("count",null);
        int b = (int)a.get("count");*/

/*
        MyThread myThread = new MyThread();
        Thread a = new Thread(myThread,"A");
        Thread b = new Thread(myThread,"B");
        Thread c = new Thread(myThread,"C");
        Thread d = new Thread(myThread,"D");
        Thread e = new Thread(myThread,"E");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();*/

        try {
            DaemonThread thread = new DaemonThread();
            thread.setDaemon(true);
            thread.start();
            Thread.sleep(5000);
            System.out.println("i finish,so daemonTread finish too ");
        }catch (Exception e){
            e.printStackTrace();
        }

        ThreadA a =  new ThreadA();
        Object o = new Object();
    }
}
