package 多线程.打印0与奇偶书1116;

public class Main {

    public static void main(String[] args) {
        ZeroEvenOdd2 zeroEvenOdd2 = new ZeroEvenOdd2(3);
        PrintInt printInt = new PrintInt();

        new Thread(new ZeroRun(zeroEvenOdd2,printInt)).start();
        new Thread(new EvenRun(zeroEvenOdd2,printInt)).start();
        new Thread(new OddRun(zeroEvenOdd2,printInt)).start();
    }
}
