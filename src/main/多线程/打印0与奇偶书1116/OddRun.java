package 多线程.打印0与奇偶书1116;

public class OddRun implements Runnable {

    private ZeroEvenOdd2 zeroEvenOdd2;
    private PrintInt printInt;

    public OddRun(ZeroEvenOdd2 zeroEvenOdd2,PrintInt printInt) {
        this.zeroEvenOdd2 = zeroEvenOdd2;
        this.printInt = printInt;
    }

    @Override
    public void run() {
        try {
            zeroEvenOdd2.odd(printInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
