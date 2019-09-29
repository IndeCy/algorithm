import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Test3 {

    class A{
        protected final void print("method a");
    }

    class B extends A{

    }

    public static void main(String[] args) {
//        Integer[] ints = new Integer[10];
//        List<Integer> l = Arrays.asList(ints);
//        l.forEach(System.out::println);

//        int[] ints1 = new int[10];
//        String aaa= null + "";
//        System.out.println((String)null);
//        System.out.println(aaa.equals("null"));
//        System.out.println(aaa instanceof String);
//        Integer a = null;
//        System.out.println(a  == 6);

//        Boolean success = null;
//        if(success){
//            System.out.println("true");
//        }else {
//            System.out.println("false");
//        }
//        Long a = 105L;
//        System.out.println((int)a);
//        System.out.println(new BigDecimal("100").toString());
        System.out.println(-1 >>> 1);
        System.out.println(-1 >> 1);
        System.out.println((int)Math.pow(2,31) >> 8);
        System.out.println((int)Math.pow(2,31) >>> 8);

        new B().print();

    }
}
