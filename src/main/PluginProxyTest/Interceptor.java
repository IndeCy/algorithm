package PluginProxyTest;

public interface Interceptor {

    Object intercept(Invocation invocation);

    Object plugin(Object target);

}
