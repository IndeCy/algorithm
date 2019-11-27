package 反转元音字母345;

import java.util.Arrays;

public class Solution {

    public static String reverseVowels(String s) {
        int left=0,right=s.length()-1;
        char[] ss = s.toCharArray();
        while(right > left){
            while(!isVowl(ss[left]) && right > left){
                left++;
            }
            while(!isVowl(ss[right]) && right > left){
                right--;
            }
            char temp = ss[left];
            ss[left] = ss[right];
            ss[right] = temp;
            left++;
            right--;
        }
        return new String(ss);

    }

    private static boolean isVowl(char c){
        switch (c) {
            case 'a':
            case 'A':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
            case 'o':
            case 'O':
            case 'U':
            case 'u':return true;
        }
        return false;
    }


    public static void main(String[] args) {
        reverseVowels("hello");
    }
}
