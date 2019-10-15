package String为什么是不可变的;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    /**
     * java采用的是值传递，对于引用变量，传递的是引用的值，也就是说让实参和形参同时指向了同一个对象，因此让形参重新指向另一个对象对实参并没有任何影响。
     * 所以这里的test.str不会改变
     * @param args
     */
    public static void main(String[] args) {
        StringTest test = new StringTest();
        char[] chars = new char[]{'a', 'b', 'c'};
        test.exchange(test.i,test.str,chars);
        System.out.println(test.str);
        System.out.println(chars);
        System.out.println(test.i);
    }
}
