package 重复的子字符串459;

public class Solution {

    /**
     * 正则解法
     */
    public boolean repeatedSubstringPattern(String s) {
        return s.matches("(\\w+)\\1+");
    }

    /**
     * 普通解法 找最小字串尝试split最后结果为0则找到否则不是
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern2(String s) {

        if(s.length() <= 1){
            return false;
        }
        for (int i = s.length() - 1; i >=1 ; i--) {
            if(s.length() % i == 0){
                String sub = s.substring(0,i);
                if(s.split(sub).length == 0){
                    return true;
                }
            }
        }
        return false;
    }



}
