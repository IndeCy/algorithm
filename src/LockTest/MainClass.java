package LockTest;

public class MainClass {

    public static void main(String[] args) throws InterruptedException{
        TestService testService = new TestService();
        ThreadA threadA = new ThreadA(testService);
        threadA.setName("A");
//        threadA.run();
        threadA.start();
        System.out.println("aaaaaaa");
        Thread.sleep(3000);
        testService.signal();
    }
}
