package easy.excel表序列号;

public class Solution {

    /**
     * 从高位遍历 高位乘以26加上低位数值
     * @param s
     * @return
     */
    public static int titleToNumber(String s) {
        char[] ss = s.toCharArray();
        int res = 0;
        int num;
        for (char s1 : ss) {
            num  = s1 - 'A' + 1;
            res = res * 26 + num;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));

    }
}
