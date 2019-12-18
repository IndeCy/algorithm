package 排列硬币441;

public class Solution {

    /**
     * 用等差数列求和公式
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        long res = 1;
        while((res * (res+1)) >>> 1 < n) res++;
        return (int)((res * (res+1)) >>> 1 == n ? res : --res);
    }

    public int arrangeCoins2(int n) {

        //这接这样写不行 会超限
//        return (int)(Math.sqrt(n*2 + 0.25d) - 0.5d);
        //做函数变换 将2提取出来 完美
        return (int)(Math.sqrt(2)*Math.sqrt(n + 0.125d) - 0.5d);
    }
}
