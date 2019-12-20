package easy.判断子序列392;

public class Solution {

    /**
     * s中的字符在t中会按顺序出现 所以按顺序查找s中的每个字符即可
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        char[] ss = s.toCharArray();
        int start = 0;
        for (char c : ss) {
            int idx;
            if((idx = t.indexOf(c,start)) < 0){
                return false;
            }else {
                start = idx + 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isSubsequence("abcd","ahbgdc");
    }
}
