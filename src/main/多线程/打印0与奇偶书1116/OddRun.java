package 多线程.打印0与奇偶书1116;

import main.多线程.打印0与奇偶书1116.ZeroEvenOddI;

public class OddRun implements Runnable {

    private ZeroEvenOddI zeroEvenOdd;
    private 多线程.打印0与奇偶书1116.PrintInt printInt;

    public OddRun(ZeroEvenOddI zeroEvenOdd2, 多线程.打印0与奇偶书1116.PrintInt printInt) {
        this.zeroEvenOdd = zeroEvenOdd2;
        this.printInt = printInt;
    }

    @Override
    public void run() {
        try {
            zeroEvenOdd.odd(printInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
