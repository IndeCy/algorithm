package LockTest.Lock0726;

public class ThreadA extends Thread {
    private MyService service;
    public ThreadA(MyService service){
        this.service = service;
    }

    @Override
    public void run(){
        for(int i = 0; i< Integer.MAX_VALUE;i++) {
            service.get();
        }
    }
}
