package easy.proxyTest;

public class IUserServiceImpl implements IUserService {
    @Override
    public void request() {
        System.out.println("iuser service in");
    }
}
