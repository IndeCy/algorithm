package main.LockTest.Lock0726;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        /*MyService service = new MyService();

        ThreadA a = new ThreadA(service);
        ThreadB b = new ThreadB(service);
        ThreadA[] as = new ThreadA[10];
        ThreadB[] bs = new ThreadB[10];

        for (int i =0 ;i<10;i++){
            as[i] = new ThreadA(service);
            bs[i] = new ThreadB(service);
            as[i].start();
            bs[i].start();
        }*/

       /* a.setName("a");
        a.start();
        b.setName("b");
        b.start();*/
       /*String a = "123,234";

       String b = "123234";
        System.out.println(a.split(",")[0]);
        System.out.println(b.split(",")[0]);

        Objects.requireNonNull(new easy.Object());
        int n = 64;
        n |= n >> 1;
//        n= n|n>>1;
        System.out.println(n);*/
       /*int a = 6;
       int b = 4;
       Integer c = 100;
       String s = "ssdf";
       easy.Object o = new easy.Object();
       o.hashCode();


        System.out.println(s.hashCode());
        System.out.println(c.hashCode());
        System.out.println(a^b);
        System.out.println(null == null);*/
       /*String[] idArr = {"a","b","c"};
        String ids = idArr[0];
        for(int i = 1;i<idArr.length;i++){
                ids += ","+idArr[i];
        }


       
        System.out.println(ids);*/
/*
        Calendar ca = Calendar.getInstance();
        System.out.println(ca.getTime());
        ca.add(Calendar.DATE,1);
        System.out.println(ca.getTime());
        Date settlementDate = ca.getTime();
        settlementDate.setHours(2);
        settlementDate.setMinutes(0);
        settlementDate.setSeconds(0);
        System.out.println(settlementDate);*/
        Byte a = 127;
        Byte b = -128;
        System.out.println(a);
        System.out.println(b);
        int i = 123;
        System.out.println(i);
        i >>>= 1;
        System.out.println(i);

        long l = 1234;
        long r = 2345;
        long t = l ^ r;
        class TreeNode<T extends Comparable<T>>{

        }
        Set set = new HashSet();
        set.containsAll(new HashSet<>());

    }
}
