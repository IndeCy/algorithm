package 多线程.按序打印1114;

public class PrintJob implements Runnable {

    private String a;

    public PrintJob(String a) {
        this.a = a;
    }

    @Override
    public void run() {
        System.out.println(a);
    }
}
