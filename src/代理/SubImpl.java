package 代理;

public class SubImpl implements ISubject{
    @Override
    public void print() {
        System.out.println("print!");
    }

    @Override
    public void before() {
        System.out.println("before!");
    }
}
