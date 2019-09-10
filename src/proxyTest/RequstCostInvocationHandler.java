package proxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RequstCostInvocationHandler implements InvocationHandler {

    private Object target;

    public RequstCostInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("request")){
            Long startTime = System.currentTimeMillis();
            method.invoke(target,args);
            Thread.sleep(3000);
            System.out.println("request cost time :"+(System.currentTimeMillis() - startTime));
        }
        return null;
    }

    public static void main(String[] args) {
        IUserService iUserService =
                (IUserService) Proxy.newProxyInstance(IUserService.class.getClassLoader(),new Class[]{IUserService.class},new RequstCostInvocationHandler(new IUserServiceImpl()));
        IProductService iProductService =
                (IProductService) Proxy.newProxyInstance(IProductService.class.getClassLoader(),new Class[]{IProductService.class},new RequstCostInvocationHandler(new IProductServiceImpl()));

        iUserService.request();
        iProductService.request();
    }
}
