package 多线程;

import java.util.concurrent.Callable;

public class ConcurrentTest {

    public static void main(String[] args) {
        Callable<String> callable = () -> "callable";
        try {
            String call = callable.call();
            System.out.println(call);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Thread run(){
      return new Thread(() -> System.out.println("runnable"));
    }


}
