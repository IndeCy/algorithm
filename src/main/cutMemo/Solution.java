package main.cutMemo;

public class Solution {
    public static void main(String[] args) {
        //价格表
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.printf(cut(p, 10) + "");
    }

    public static int cut(int[] p, int n) {
        if (n == 0) {
            return 0;
        }
        int q = Integer.MIN_VALUE;
        //i代表切割长度
        for (int i = 1; i <= n; i++) {
            q = Math.max(q, p[i - 1] + cut(p, n - i));
        }
        return q;
    }
}
