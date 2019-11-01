package 阶乘后的0;

public class Solution {

    /**
     * 转换思路 10的来源只有2*5
     * 经过分析 5的个数是肯定小于2的
     * 其实是求解 乘数中有多少质数因子5
     *
     * 0! = 1
     * 1! = 1
     * 2! = 2^1 * 5^0 * 1
     * 3! = 2^1 * 5^0 * 3
     * 4! = 2^3 * 5^0 * 3
     *
     * 5! = 2^3 * 5^1 * 3
     * 6! = 2^4 * 5^1 * 3^2
     * 7! = 2^4 * 5^1 * x
     * 8! = 2^7 * 5^1 * x
     * 9! = 2^7 * 5^1 * x
     *
     * 10! = 2^8 * 5^2 * x
     * 11! = 2^8 * 5^2 * x
     * 12! = 2^10 * 5^2 * x
     * 13! = 2^10 * 5^2 * x
     * 14! = 2^11 * 5^2 * x
     *
     * 15! = 2^11 * 5^3 * x
     * 16! = 2^15 * 5^3 * x
     *  // 不关注其它质因数，用x代替
     * 24! = 5^i * x
     *
     * 25! = 5^(i+2) * x
     * 26! = 5^(i+2) * x
     * 27! = 5^(i+2) * x
     * 28! = 5^(i+2) * x
     * 29! = 5^(i+2) * x
     *
     * 30! = 5^(i+3) * x
     * 35! = 5^(i+4) * x
     * 40! = 5^(i+5) * x
     * 45! = 5^(i+6) * x
     *
     * 49! = 5^j * x
     * 50! = 5^(j+2) * x
     * 51! = 5^(j+2) * x
     *
     * 74! = 5^k * x
     * 75! = 5^(k+2) * x
     * 76! = 5^(k+2) * x
     *
     * -------------------------
     * 125! = 124! * 5^3
     * 250! = 249! * 5^3 * 2
     * 375! = 374! * 5^3 * 3
     * 500! = 499! * 5^3 * 4
     * 625! = 624! * 5^4
     * 观察规律可以发现 每五个数为一组 比前面一组的5的个数多1 在 25，125，··这些情况时比前面一组多再多多1个
     * 所以将他们分5个一组 25个一组 125 个一组 以此类推
     * @param n
     * @return
     */
    public static int trailingZeroesTrue(int n) {
        int count = 0;
        while(n > 0){
            count += n/5;
            n /= 5;
        }
        return count;
    }


    /**
     * 这种暴力接解法不行 会超时
     * @param n
     * @return
     */
    public static int trailingZeroes(int n) {
        long res = 1L;
        int count = 0;
        while(n > 0){
            res *= n;
            if(res % 10 == 0){
                count ++;
                res /= 10;
            }
            n--;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
        System.out.println(trailingZeroesTrue(30));
    }
}
