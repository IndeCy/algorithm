package 最长回文串409;

public class Solution {

    /**
     * 前后双指针 左指针和右指针放的字符是一样的直到所有的偶数字符用完再加上一个基数字符即可
     * 直接计算偶数的字符数+1就是
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        int[] count = new int[52];
        int res = 0;
        for (char a: s.toCharArray()) {
            if(Character.isLowerCase(a)) {
                count[a - 'a']++;
            }else{
                count[a - 'A' + 26]++;
            }
        }
        boolean flag = false;
        for (int i = 0; i < count.length; i++) {
            res += (count[i] / 2) * 2;
            if(count[i] % 2 == 1){
                flag = true;
            }
        }
        return flag ? res + 1 : res;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaAaaaa"));
    }
}
