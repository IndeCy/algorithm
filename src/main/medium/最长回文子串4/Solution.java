package medium.最长回文子串4;

public class Solution {


    /**
     * 动态规划
     * 1.、定义 “状态”，这里 “状态”数组是二维数组
     * dp[l][r] 表示子串 s[l, r]（包括区间左右端点）是否构成回文串，是一个二维布尔型数组。即如果子串 s[l, r] 是回文串，那么 dp[l][r] = true。
     * 2.定义状态转移方程
     * dp[l, r] = (s[l] == s[r] and (r - l <= 2 or dp[l + 1, r - 1]))
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if("".equals(s) || s.length() == 1){
            return s;
        }
        String maxSubString = s.substring(0,1);
        int maxLen = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int r = 1; r < s.length(); r++) {
            for (int l = 0; l < r; l++) {
                if(s.charAt(l) == s.charAt(r) && (r - l  <= 2 || dp[l+1][r-1])){
                    dp[l][r] = true;
                    if (r-l+1>maxLen) {
                        maxLen = r - l + 1;
                        maxSubString = s.substring(l,r+1);
                    }
                }
            }
        }
        return maxSubString;
    }

    public static void main(String[] args) {

        longestPalindrome("aaaa");
    }
}
