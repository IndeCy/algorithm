package 线程间传递值;

import java.lang.reflect.Field;

/**
 * @author icodening
 * @date 2021.01.31
 */
public class MyRunnable implements Runnable {

    private Object threadLocal;

    private Runnable runnable;

    public MyRunnable(Runnable runnable, Object threadLocal) {
        this.runnable = runnable;
        this.threadLocal = threadLocal;
    }

    @Override
    public void run() {
        try {
            Field threadLocals = Thread.class.getDeclaredField("threadLocals");
            Thread thread = Thread.currentThread();
            threadLocals.setAccessible(true);
            threadLocals.set(thread, threadLocal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        runnable.run();
    }
}
