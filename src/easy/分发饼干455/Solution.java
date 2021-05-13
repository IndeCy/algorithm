package easy.分发饼干455;

import java.util.Arrays;

public class Solution {


    /**
     * 这原来就是贪心算法
     * 先排序在从小到大分配
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int i = 0;
        int j=0;
        while(i<g.length && j<s.length){
            if(g[i] <= s[j]) {
                i++;j++;res++;
            }else {
                j++;
            }
        }

        return res;
    }
}
