package PluginProxyTest;

import PluginProxyTest.*;

public class Main {
    public static void main(String[] args) {
        InterceptorChain interceptorChain = new InterceptorChain();
        interceptorChain.addInterceptor(new FirstInterceptor());
        interceptorChain.addInterceptor(new SecondInterceptor());
        IGetStr getStr = new GetStrImpl();
        getStr = (IGetStr)interceptorChain.pluginAll(getStr);

        String result = getStr.getOne();

        System.out.println(result);

        result = getStr.getZero();

        System.out.println(result);

    }
}
