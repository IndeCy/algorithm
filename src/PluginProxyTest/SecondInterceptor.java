package PluginProxyTest;

import java.lang.reflect.InvocationTargetException;

public class SecondInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) {
        try {
            return "plugin2"+invocation.proceed()+"plugin2";
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }
}
