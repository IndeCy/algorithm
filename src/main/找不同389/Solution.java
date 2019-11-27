package 找不同389;

import java.util.Arrays;

public class Solution {

    /**
     * 先排序再进行一次遍历  考虑特殊情况 加在最后一个时 添加的值就是较长字符串的最后一位
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(ts);
        for(int i=0;i < Math.min(ss.length,ts.length);i++){
            if(ss[i] != ts[i]){
                return ss.length > ts.length ? ss[i] : ts[i];
            }
        }
        return ss.length > ts.length ? ss[ss.length-1] : ts[ts.length-1];
    }

    /**
     * 法二 抑或 出现两次的字符抑或完了变成0 最后那个即是添加的值
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference2(String s, String t) {
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            a ^= s.charAt(i);
        }
        for(int i = 0; i< t.length();i++){
            a ^= t.charAt(i);
        }
        return (char)a;
    }


}
