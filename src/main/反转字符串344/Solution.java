package 反转字符串344;

public class Solution {

    /**
     * 左右双指针
     * @param s
     */
    public void reverseString(char[] s) {
        int left=0,right=s.length-1;
        while(right > left){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 通过递归的方式实现假设终止字符是'#'
     * @param s
     */
    public static void reverseString2(){
        print('f');
    }

    private static void print(char c){
        if(c != '0'){
            print((char) (c-1));
        }
        System.out.println(c);
    }

    public static void main(String[] args) {
        reverseString2();
    }

}
