package easy.二的幂231;

public class Solution {

    /**
     * 二进制右移运算
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if(n < 0){
            return false;
        }
        int count = 0;
        for(int i =0;i< 32;i++){
            if(((n >> i) & 1) == 1){
                count++;
            }
        }
        return count == 1;
    }

    /**
     * 大佬牛逼解法
     * 若 n = 2^xn=2
     * x
     *   且 xx 为自然数（即 nn 为 22 的幂），则一定满足以下条件：
     * 恒有 n & (n - 1) == 0，这是因为：
     * n二进制最高位为 1，其余所有位为 0；
     * n - 1二进制最高位为 0，其余所有位为 1；
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
}
