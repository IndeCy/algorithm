package 代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubInvocation implements InvocationHandler {

    private ISubject obj;

    public SubInvocation(ISubject obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-- proxy --");
        return method.invoke(obj,args);
    }
}
