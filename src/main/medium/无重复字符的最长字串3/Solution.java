package medium.无重复字符的最长字串3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    /**
     * 自己实现的滑动窗口 O(n)时间复杂度 O(1)空间复杂度
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        int res = 0;
        int start = 0;
        String sub = "";
        out:while(start + 1 < s.length()) {
            for (int j = 1; j <= s.length(); j++) {
                int index = -1;
                sub = s.substring(start, start + j);
                if(start + j >= s.length()){
                    break out;
                }
                char temp = s.charAt(start + j);
                if ((index = sub.indexOf(temp)) != -1) {
                    start = start + index + 1;
                    res = Math.max(res,sub.length());
                    sub = "";
                    break;
                }
            }
        }
        return Math.max(res,sub.length());
    }

    /**
     * 标准滑动窗口 i代表开始位置 j代表结束位置
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int i =0,j=0,ans=0;
        while(i < s.length() && j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans,set.size());
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 优化的滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("auk"));
    }
}
