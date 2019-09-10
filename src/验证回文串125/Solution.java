package 验证回文串125;

public class Solution {

    public boolean isPalindrome(String s) {
        int first = 0;
        int tail = s.length() - 1;
        char[] ss = s.toCharArray();
        while(first < tail){
            while(first < tail && !isRight(ss[first])) first++;
            char h = Character.toLowerCase(ss[first]);
            while(first < tail && !isRight(ss[tail])) tail--;
            char t = Character.toLowerCase(ss[tail]);
            first++;
            tail--;
            if(h!=t){
                return false;
            }
        }
        return true;
    }

    private boolean isRight(char a){
        if((a >= 'a' && a <= 'z') || (a >= '0' && a <= '9') || (a >= 'A' && a <= 'Z')){
            return true;
        }
        return false;
    }
}
