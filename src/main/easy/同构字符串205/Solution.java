package easy.同构字符串205;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    /**
     * 字典表法 失败条件是 1 映射表的值出现了重复 证明不同的字符被映射到同一个字符上
     *                   2 用s的字符映射字符按顺序组起来!=t
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        StringBuilder sb = new StringBuilder(sc.length);
        HashMap<Character,Character> map = new HashMap<>(sc.length);
        for (int i = 0; i < sc.length; i++) {
            map.putIfAbsent(sc[i],tc[i]);
            sb.append(map.get(sc[i]));
        }
        if(map.values().size() != new HashSet<>(map.values()).size()){
            return false;
        }
        return sb.toString().equals(t);
    }

    /**
     * 大佬的巧妙解法
     * 两个字符串的相同位置的字符在字符串中第一次出现的位置一定相同
     * 案例 abb nmm   遍历到第二个字符时 第一次出现的位置永远是 1
     *      aab nmm   遍历到第二个字符时 s串第一次出现的位置时 0 而t串第一次出现的位置是1 它们不一样
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic2(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(s.indexOf(ch1[i]) != t.indexOf(ch2[i])){
                return false;
            }
        }
        return true;
    }

}
