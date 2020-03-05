package easy.threadTest.测试主线程创建runnable类;

import java.math.BigDecimal;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) throws Exception{
        System.out.println(Thread.currentThread().getName() + "main thread before");

        Runnable runnable = () -> System.out.println(Thread.currentThread().getName() + "fork 的 自线程打印");
        Thread thread = new Thread(runnable);
//        thread.start();
//        Thread.sleep(2000);

        System.out.println(Thread.currentThread().getName() + "main thread after");
        System.out.println(new BigDecimal("100").toString());
        System.out.println(BigDecimal.TEN.toString());
        Object obj = new Object();
        Predicate<Object> equal = Predicate.isEqual(obj);
    }
}
