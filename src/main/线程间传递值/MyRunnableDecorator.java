package 线程间传递值;

import org.springframework.core.task.TaskDecorator;

import java.lang.reflect.Field;

/**
 * @author icodening
 * @date 2021.01.31
 */
public class MyRunnableDecorator implements TaskDecorator {
    @Override
    public Runnable decorate(Runnable runnable) {
        MyRunnable myRunnable = null;
        try {
            Thread parentThread = Thread.currentThread();
            Field inheritableThreadLocals = Thread.class.getDeclaredField("threadLocals");
            inheritableThreadLocals.setAccessible(true);
            Object o = inheritableThreadLocals.get(parentThread);
            myRunnable = new MyRunnable(runnable, o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myRunnable;
    }
}
