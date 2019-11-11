package 有效的字母异位词242;

import java.util.Arrays;

public class Solution {

    /**
     * 通过hash表来映射个数 太浪费空间了
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] res1 = new int[1024];
        int[] res2 = new int[1024];
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        for(char i : ss){
            res1[i] ++;
        }
        for(char j : ts){
            res2[j] ++;
        }
        return Arrays.equals(res1,res2);
    }

    /**
     * 通过hash表来映射  优化版
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] res = new int[26];
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        for(int i = 0;i< ss.length ;i++){
            res[s.charAt(i) - 'a']++;
            res[t.charAt(i) - 'a']--;
        }
        for(int i : res){
            if(i!=0){
                return false;
            }
        }
        return true;
    }


}
