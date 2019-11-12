package 单词规律290;

import java.util.HashMap;

public class Solution {


    /**
     * 同之前一道题  判断字符/字符串在参数中第一次出现的位置 如果都一样就是一致的
     * @param pattern
     * @param str
     * @return
     */
    public static boolean wordPattern(String pattern, String str) {
        String[] ss = str.split(" ");
        HashMap<String,Integer> hashMap = new HashMap<>();
        int j = 0;
        for (String s : ss) {
            hashMap.putIfAbsent(s,j++);
        }
        if(pattern.length() != ss.length){
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if(pattern.indexOf(pattern.charAt(i)) != hashMap.get(ss[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        wordPattern("abba","dog cat cat dog");
    }
}
