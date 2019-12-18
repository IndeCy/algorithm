package 压缩字符串443;

import common.GenerateList;

public class Solution {

    /**
     * 双指针顺着思路撸下来的代码
     * @param chars
     * @return
     */
    public static int compress(char[] chars) {
        //开始替换的值
        int k = 0;
        for (int i = 0; i < chars.length; ) {
            int temp = 1;
            int j = i+1;
            for (; j <= chars.length; j++) {
                if(j!=chars.length && chars[i] == chars[j]){
                    temp++;
                }else {
                    chars[k++] = chars[i];
                    if (temp != 1) {
                        String tempStr = String.valueOf(temp);
                        for (char t : tempStr.toCharArray()) {
                            chars[k++] = t;
                        }
                    }
                    break;
                }
            }
            i = j;
        }
        return chars.length == 1 ? 1 : k;
    }

    /**
     * 官方题解思路一样代码简洁
     * @param chars
     * @return
     */
    public static int compress2(char[] chars) {
        //anchor记录当前第一次读到不同字符的位置 write写的结束位置
        int anchor = 0,write = 0;
        for (int read = 0; read < chars.length; read++) {
            if(read + 1 == chars.length || chars[read + 1] != chars[read]){
                chars[write++] = chars[anchor];
                //如果读的位置比第一次读到的大 则不止一个字符
                if(read > anchor){
                    for(char c : ("" + (read - anchor + 1)).toCharArray()){
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }


    public static void main(String[] args) {

//        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
        System.out.println(compress2(new char[]{'a','a','b','b','c','c','c'}));
    }
}
