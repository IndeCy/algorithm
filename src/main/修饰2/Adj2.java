package 修饰2;

import 修饰1.Adj1;

public class Adj2 extends Adj1 {

    public static void main(String[] args) {
        /**
         * public 跨包可见
         */
        System.out.println(Adj1.pubS);

        /**
         * protect 继承可见
         */
        System.out.println(Adj1.proS);

        /**
         * 默认级别跨包不可见
         */


    }
}
