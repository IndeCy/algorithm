package PluginProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Plugin implements InvocationHandler {

    private final Object target;
    private final Interceptor interceptor;

    public Plugin(Object target,Interceptor interceptor){
        this.target = target;
        this.interceptor = interceptor;
    }

    public static Object wrap(Object target,Interceptor interceptor){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),new Class[]{IGetStr.class},new Plugin(target,interceptor));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("getZero")){
            return interceptor.intercept(new Invocation(target,method,args));
        }
        return method.invoke(target,args);
    }
}
