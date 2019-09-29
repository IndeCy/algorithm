package main.LockTest.Lock0726;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private boolean hasValue = false;

    private String value;

    public void set(){
        try {
            lock.lock();
            while(hasValue){
                System.out.println("有可能 set √√√ 连续");
                condition.await();
            }
            System.out.println("set √√√");
//            Thread.sleep(1000);
            value = "stringValue";
            hasValue = true;
            condition.signalAll();
        }catch (InterruptedException e){

        }finally {
            lock.unlock();
        }
    }

    public void get(){
        try{
            lock.lock();
            while (!hasValue){
                System.out.println("有可能 get ∫∫∫ 连续");
                condition.await();
            }
            System.out.println("get ∫∫∫");
//            Thread.sleep(1000);
            hasValue = false;
            condition.signalAll();
        }catch (InterruptedException e){

        }finally {
            lock.unlock();
        }

    }
}
