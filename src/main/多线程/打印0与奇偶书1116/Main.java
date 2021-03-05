package 多线程.打印0与奇偶书1116;

import main.多线程.打印0与奇偶书1116.ZeroEvenOdd3;

public class Main {

    public static void main(String[] args) {
//        ZeroEvenOdd2 zeroEvenOdd2 = new ZeroEvenOdd2(3);
//        PrintInt printInt = new PrintInt();
//
//        new Thread(new ZeroRun(zeroEvenOdd2,printInt)).start();
//        new Thread(new EvenRun(zeroEvenOdd2,printInt)).start();
//        new Thread(new OddRun(zeroEvenOdd2,printInt)).start();


        ZeroEvenOdd3 zeroEvenOdd3 = new ZeroEvenOdd3(3);
        多线程.打印0与奇偶书1116.PrintInt printInt = new 多线程.打印0与奇偶书1116.PrintInt();

        new Thread(new 多线程.打印0与奇偶书1116.ZeroRun(zeroEvenOdd3,printInt)).start();
        new Thread(new 多线程.打印0与奇偶书1116.EvenRun(zeroEvenOdd3,printInt)).start();
        new Thread(new 多线程.打印0与奇偶书1116.OddRun(zeroEvenOdd3,printInt)).start();
    }
}
