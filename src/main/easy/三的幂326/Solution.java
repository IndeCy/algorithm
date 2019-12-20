package easy.三的幂326;

public class Solution {


    /**
     * 暴力破解
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        while(n>2){
            if(n%3 == 0){
                n /= 3;
            }else {
                return false;
            }
        }
        return n==1;
    }

    /**
     * 换基 即转换进制判断是否只有第一位为1其他位都为0
     * @param n
     * @return
     */
    public boolean isPowerOfThree2(int n) {
        //转化为三进制字符串
        String sanjinzhi = Integer.toString(n,3);
        String regex = "^10*$";
        return sanjinzhi.matches(regex);
    }
}
