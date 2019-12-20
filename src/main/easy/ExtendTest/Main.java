package main.ExtendTest;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        B c = (B)a;
//        A d = (A)b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        String ss = "水月镜花";
        System.out.println(ss.length());
//        System.out.println(d);
        System.out.println(19+(-1));
        List<Object> ll = new ArrayList<>();
        for(Object obj : ll){
            System.out.println("aaaaa");
        }
    }

    static class A extends B{
        private int a;
        private int c;
    }

    static class B{
        private int b;
    }


}
