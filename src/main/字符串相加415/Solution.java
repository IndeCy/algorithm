package 字符串相加415;

public class Solution {

    /**
     * 直接对单个字符操作
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int ins = 0;
        StringBuilder sb = new StringBuilder();
        int i = num1.length() -1,j = num2.length() -1;
        for (; i >=0 && j>=0; i--,j--) {
            int temp = c1[i] + c2[j] - 96 + ins;
            ins = 0;
            if(temp >= 10){
                ins = 1;
                temp -= 10;
            }
            sb.append((char)(temp + 48));
        }
        while(i >= 0){
            int temp = c1[i--] - 48 + ins;
            ins = 0;
            if(temp >= 10){
                ins = 1;
                temp -= 10;
            }
            sb.append((char)(temp + 48));
        }
        while(j >= 0){
            int temp = c2[j--] - 48 + ins;
            ins = 0;
            if(temp >= 10){
                ins = 1;
                temp -= 10;
            }
            sb.append((char)(temp + 48));
        }
        if(ins == 1){
            sb.append("1");
        }
        return sb.reverse().toString();
    }


    /**
     * 思路跟上面的一样都是双指针遍历  区别是比上面代码优雅
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings2(String num1, String num2) {
        int i = num1.length() - 1,j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int temp = n1 + n2 + carry;
            carry = temp / 10;
            sb.append(temp % 10);
        }
        if(carry > 0) sb.append('1');
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        addStrings("1","9");
    }

}
