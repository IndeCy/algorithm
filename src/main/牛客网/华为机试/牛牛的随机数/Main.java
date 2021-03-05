package main.牛客网.华为机试.牛牛的随机数;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /**
     * 最基本的实现思路  31ms 10628k
     *
     * @param args
     */
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String s = sc.nextLine();
//            int j = 1;
//            while (s.length() >= 8 * j) {
//                System.out.println(s.substring((j - 1) * 8, j++ * 8));
//
//            }
//            if (s.length() % 8 == 0) {
//                continue;
//            }
//            String s2 = s.substring((j - 1) * 8);
//            char[] r = new char[8];
//            Arrays.fill(r, '0');
//            char[] ss = s2.toCharArray();
//            int i = 0;
//            for (char c : ss) {
//                r[i++] = c;
//            }
//            System.out.println(new String(r));
//        }
//    }

    /**
     * 大佬思路 先拼成超过8的整数倍长度，然后切分  33ms 10644k
     */
    public static void main(String...a) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.length() % 8 != 0) s = s + "00000000";
            while(s.length() >= 8){
                System.out.println(s.substring(0,8));
                s = s.substring(8);
            }


        }
    }


}
