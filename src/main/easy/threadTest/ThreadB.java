package easy.threadTest;

public class ThreadB extends Thread{
    private int count = 5;


    @Override
    public void run(){
        System.out.println(count--);
    }
}
