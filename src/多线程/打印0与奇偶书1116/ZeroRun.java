package 多线程.打印0与奇偶书1116;

public class ZeroRun implements Runnable{


    private ZeroEvenOddI zeroEvenOdd;
    private 多线程.打印0与奇偶书1116.PrintInt printInt;

    public ZeroRun(ZeroEvenOddI zeroEvenOdd, 多线程.打印0与奇偶书1116.PrintInt printInt) {
        this.zeroEvenOdd = zeroEvenOdd;
        this.printInt = printInt;
    }

    @Override
    public void run() {
        try {
            zeroEvenOdd.zero(printInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
