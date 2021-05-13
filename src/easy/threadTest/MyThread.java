package easy.threadTest;

public class MyThread extends Thread {

    private int count = 5;

    MyThread(){}

    MyThread(String name){
        this.setName(name);
    }

    @Override
    synchronized public void run(){


            count -- ;
            System.out.println("ThreadName:"+this.currentThread().getName()+"-----count:"+count);

    }
}

