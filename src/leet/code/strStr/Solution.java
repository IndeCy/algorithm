package leet.code.strStr;

public class Solution {
    public static void main(String[] args) {
        System.out.printf(strStr("mississippi","issipi")+"");
    }

    public static int strStr(String haystack, String needle){
        if("".equals(needle)){
            return 0;
        }
        if(haystack.length()<needle.length()||"".equals(haystack)){
            return -1;
        }
        char[] a = haystack.toCharArray();
        char[] b = needle.toCharArray();
        for(int i=0;i<a.length;i++){
            int count = 0;
            int start = i;
            if(start > a.length-b.length){
                return -1;
            }
            for(int j=0;j<needle.length();j++) {
                if(b[j]==a[start++]){
                    count++;
                    if(count == needle.length()){
                        return i;
                    }
                }else{
                    break;
                }
            }
        }
        return -1;
    }
}
