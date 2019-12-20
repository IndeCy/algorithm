package easy.字符串中的单词数434;

public class Solution {


    /**
     * 快慢指针解决 麻烦 判断很多
     * @param s
     * @return
     */
    public static int countSegments(String s) {
        if(s.trim().length() <= 1){
            return s.trim().length();
        }
        s=s.trim();
        int slow = 0;
        int fast = 1;
        int res = 0;
        while(fast < s.length()){
            fast = slow + 1;
            if(s.charAt(slow) != ' '){
                res ++;
            }
            if(s.charAt(slow) != ' '){
                while(fast < s.length() && s.charAt(fast) != ' '){
                    fast ++;
                }
            }else{
                while(fast < s.length() && s.charAt(fast) == ' '){
                    fast++;
                }
            }
            slow = fast + 1;
        }
        return res;
    }

    /**
     * 双指针解法跟以上思想一样 写法更优雅
     * @param s
     * @return
     */
    public int countSegments3(String s) {
        int count = 0, i = 0, j = 0;
        while(i < s.length()) {
            while(i < s.length() && s.charAt(i) == ' ') i++;
            j = i;
            if(j < s.length()) {
                while(j < s.length() && s.charAt(j) != ' ') j++;
                count++;
                i = j;
            }
        }
        return count;
    }

    /**
     * 统计词频的解决方式 只需要遍历一遍
     */
    public static int countSegments2(String s) {
        if(s.trim().length() <= 1){
            return s.trim().length();
        }
        s=s.trim();
        int res = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' '){
                temp++;
                if(i == s.length() - 1){
                    res++;
                }
            }else if(s.charAt(i) == ' ' && temp > 0){
                res++;
                temp = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("a, b, c"));
    }
}
