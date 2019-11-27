package 字符串中第一个唯一字符387;

public class Solution {

    /**
     * 用桶来统计频次处理
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        int[] res = new int[26];
        for(char a : s.toCharArray()){
            res[a - 'a']++;
        }
        Integer temp =  null;
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 1 ){
                if(temp == null) {
                    temp = s.indexOf((char) ('a' + i));
                }else {
                    temp = Math.min(temp,s.indexOf((char)('a' + i)));
                }
            }
        }
        return temp == null ? -1 : temp;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
}
