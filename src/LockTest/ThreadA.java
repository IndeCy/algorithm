package LockTest;

public class ThreadA extends Thread {

    ThreadA(){}

    ThreadA(TestService testService){
        this.testService = testService;
    }
    private TestService testService;

    public void run(){
        testService.await();
    }
}
