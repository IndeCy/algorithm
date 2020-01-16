package 多线程.打印0与奇偶书1116;

import java.util.function.IntConsumer;

public class PrintInt implements IntConsumer {
    @Override
    public void accept(int value) {
        System.out.print(value);
        System.out.print("\t");
    }
}
