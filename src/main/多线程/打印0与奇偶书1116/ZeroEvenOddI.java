package main.多线程.打印0与奇偶书1116;

import java.util.function.IntConsumer;

public interface ZeroEvenOddI {
    public void zero(IntConsumer printNumber) throws InterruptedException;
    public void even(IntConsumer printNumber) throws InterruptedException;
    public void odd(IntConsumer printNumber) throws InterruptedException;

}
