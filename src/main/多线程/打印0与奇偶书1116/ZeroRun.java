package 多线程.打印0与奇偶书1116;

public class ZeroRun implements Runnable{


    private ZeroEvenOdd2 zeroEvenOdd2;
    private PrintInt printInt;

    public ZeroRun(ZeroEvenOdd2 zeroEvenOdd2,PrintInt printInt) {
        this.zeroEvenOdd2 = zeroEvenOdd2;
        this.printInt = printInt;
    }

    @Override
    public void run() {
        try {
            zeroEvenOdd2.zero(printInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
