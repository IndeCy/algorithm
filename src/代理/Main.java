package 代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        SubImpl sub = new SubImpl();
        ISubject o = (ISubject)Proxy.newProxyInstance(sub.getClass().getClassLoader(), sub.getClass().getInterfaces(), new SubInvocation(sub));
        o.print();
        o.before();
    }
}
