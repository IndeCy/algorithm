package 多线程.按序打印1114;

public class Main {

    public static void main(String[] args) throws Exception{

        Foo foo = new Foo();
        PrintJob one = new PrintJob("one");
        PrintJob two = new PrintJob("two");
        PrintJob three = new PrintJob("three");
        foo.second(two);
        foo.first(one);
    }
}
