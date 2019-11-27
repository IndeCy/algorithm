package 四的幂342;

public class Solution {

    //法1 暴力 不写了
    public static boolean isPowerOfFour(int n) {
        while(n>3){
            if(n%4 == 0){
                n /= 4;
            }else {
                return false;
            }
        }
        return n==1;
    }

    //法2 java解法，32位数如果是4的幂，那么只有奇数位有且只有一个1（从1开始数），偶数位都是0。判断条件为与0xaaaaaaaa做与运算结果为0。（a=1010）
    //
    //class Solution {
    //    public boolean isPowerOfFour(int num) {
    //        if((num & 0xaaaaaaaa)==0 &&Integer.bitCount(num)==1) return true;
    //        else return false;
    //    }
    //}

    /**
     * 0xaaaaaaaa 是特殊的16进制数 偶数位都为1 奇数位都为0 （从1开始数）
     * @param n
     */
    public static boolean isPowerOfFour2(int n) {
        return (n & 0xaaaaaaaa) == 0 && Integer.bitCount(n) == 1;
    }
}
