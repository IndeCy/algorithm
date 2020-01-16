package medium.Z字型变换6;

public class Solution {

    public static String convert(String s, int numRows) {
        int len = s.length();
        int i =0;
        char[][] dp = new char[numRows][len];
        int h = 0;int l = 0;
        while(i<len){
            if(h == 0){
                if(l!=0){
                    h = 1;
                }
                while(h < numRows && i < s.length()){
                    dp[h++][l] = s.charAt(i++);
                }
                l++;
            }
            if(--h == numRows - 1){
                while(h > 0 && i < s.length()){
                    dp[--h][l++] = s.charAt(i++);
                }
                if(i!= len) {
                    l--;
                }
            }
        }
        StringBuilder sb = new StringBuilder(len);
        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < l; k++) {
                if(dp[j][k] != 0) {
                    System.out.print(dp[j][k]);
                    sb.append(dp[j][k]);
                }else {
                    System.out.print(" ");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING",3));
    }
}
