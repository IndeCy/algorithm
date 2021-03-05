package main.牛客网.阿里篇.计算一个根号2的开方精确到10小数位;

/**
 * @Package: main.牛客网.阿里篇.计算一个根号2的开方精确到10小数位
 * @Author: chenyang
 * @Date: 2021/1/25
 * @Version: 1.0
 */
public class Solution {


    /**
     * 已知约等于1.414
     * @param x
     * @return
     */
    static double square(double x){
       double ceil = 1.414;
       double top = 1.415;
       double mid = (top + ceil) / 2;
       while (top - ceil > 0.000000000000001){
//           double v = (top - ceil) / 2;
           if(mid * mid < x){
               ceil = mid;
           }else {
               top = mid;
           }
           mid = (ceil  + top) / 2;
       }
       return mid;
    }


    public static void main(String[] args) {
        System.out.println( square(2.0));
        System.out.println(Math.sqrt(2.0));

    }
}
