package 多线程.打印0与奇偶书1116;

import main.多线程.打印0与奇偶书1116.ZeroEvenOddI;

public class EvenRun implements Runnable {

    private ZeroEvenOddI zeroEvenOdd;
    private 多线程.打印0与奇偶书1116.PrintInt printInt;

    public EvenRun(ZeroEvenOddI zeroEvenOdd, 多线程.打印0与奇偶书1116.PrintInt printInt) {
        this.zeroEvenOdd = zeroEvenOdd;
        this.printInt = printInt;
    }

    @Override
    public void run() {
        try {
            zeroEvenOdd.even(printInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
