package easy.PluginProxyTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invocation {

    private final Object target;
    private final Method method;
    private final Object[] args;

    public Invocation(Object target,Method method,Object[] args){
        this.args = args;
        this.target = target;
        this.method = method;
    }

    public Object proceed() throws InvocationTargetException,IllegalAccessException {
        return method.invoke(target,args);
    }
}
