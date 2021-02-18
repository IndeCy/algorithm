package 修饰1;

public class Adj1 {
    /**
     * 跨包可见
     */
    public static String pubS = "pubs";
    /**
     * 跨包继承可见
     * 跨包不继承不可见
     */
    protected static String proS = "pros";

    /**
     * 只有自己可见
     */
    private static String priS = "pris";
    /**
     * 同包可见 跨包不可见
     * 继承跨包也不可见
     */
    static String defS = "defS";
}
