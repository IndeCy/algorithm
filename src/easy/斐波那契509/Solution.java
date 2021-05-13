package easy.斐波那契509;

/**
 * @Package: easy.斐波那契509
 * @Author: chenyang
 * @Date: 2021/1/6
 * @Version: 1.0
 */
public class Solution {

    /**
     * 递归算法 效率差 内存大
     * @param n
     * @return
     */
    public static int fib(int n) {
        if(n <= 1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    /**
     * 动态规划 用三个元素的数组来做状态转移，方程为r = p + q
     *   0   0   1
     * | p | q | r |
     *
     * 将每次的结果放到第三个位置，同时将之前俩个数前移
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(fib(4));
    }
}
