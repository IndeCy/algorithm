package easy.统计质数;

import java.util.Arrays;

public class Solution {

    public int countPrimes(int n) {
        boolean[] ss = new boolean[n];
        Arrays.fill(ss,true);
        /**
         * 根据质数的对称性 只需要遍历 [2,sqr(n)]
         */
        for (int i = 2; i*i < n; i++) {
            if(ss[i]){
                /**
                 * 同样的 j = 2*i的数其实已经被 i=2时标记过了 也可以优化成 j=i*i
                 */
                for (int j = i*i; j < n; j+=i) {
                    ss[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(ss[i]){
                count++;
            }
        }
        return count;
    }

    private boolean isPrimes(int n){
        for (int i = 2; i * i < n  ; i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
