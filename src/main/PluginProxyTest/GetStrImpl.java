package PluginProxyTest;

public class GetStrImpl implements IGetStr {
    @Override
    public String getOne() {
        return "1";
    }

    @Override
    public String getZero() {
        return "0";
    }
}
