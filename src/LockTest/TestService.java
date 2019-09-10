package LockTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void await(){
        try {
            lock.lock();
            System.out.println("method await   " + Thread.currentThread().getName() + "--" + System.currentTimeMillis());
            condition.await();
            System.out.println("method after await");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signal(){
        try{
            lock.lock();
            System.out.println("method signal " + Thread.currentThread().getName() + "--" + System.currentTimeMillis());
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
