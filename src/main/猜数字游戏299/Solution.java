package 猜数字游戏299;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Consumer;

public class Solution {


    /**
     * 由于字符串中只有0-9的数字
     * 我们可以用一个数组来处理两个字符串的字符出现次数
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        int length = secret.length();
        int bulls=0,cows=0;
        int[] stack = new int[10];
        for (int i = 0; i < length; i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if(s==g){
                bulls++;
            }else {
                stack[s]++;
                stack[g]--;
            }
        }
        //取数组中大于0的值 证明 secret中出现的次数比guess中多的次数 把这些从secret中删除就剩两方都出现的次数 再减去公牛就剩母牛
        for (int i = 0; i < stack.length; i++) {
            if(stack[i] > 0){
                cows += stack[i];
            }
        }
        cows = secret.length() - cows - bulls;
        return bulls+"A"+cows+"B";
    }
}
