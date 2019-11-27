package 有效的完全平方数367;

import java.util.Map;

public class Solution {


    /**
     * 根据题意  判断 x^2 > 2x 时 x > 2即x^2 > 4 此时num的平方根必然小于它的一半
     * 我们可以一直循环取到根所在的范围 遍历范围判断平方是否为num 如果是则true否则false
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if(num < 5){
            return num == 4 || num == 1;
        }
        int start = num >>> 2,end = num >>> 1;
        while(!(Math.pow(start, 2) < num)) {
            if(Math.pow(start, 2) > num){
                end = start;
                start = start >>> 1;
            }else{
                return true;
            }
        }
        for(int i = start;i <= end ;i++){
            if(Math.pow(i,2) == num){
                return true;
            }
        }
        return false;
    }

    /**
     * 二分查找法 注意此处必须用long避免数字越界导致判断异常
     * @param num
     * @return
     */
    public static boolean isPerfectSquare2(int num) {
        if(num == 1){
            return true;
        }
        long start = 1;
        long end = num;
        long mid = num >>> 1;
        while(start <= end){
            if(mid * mid == num){
                return true;
            }else if(mid * mid < num){
                start = mid + 1;
                mid = (start + end) >>> 1;
            }else if(mid * mid > num){
                end = mid - 1;
                mid = (start + end) >>> 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare2(2147483647));
    }



}
