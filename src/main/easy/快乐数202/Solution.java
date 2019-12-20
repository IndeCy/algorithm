package easy.快乐数202;

public class Solution {

    /**
     * 太暴力了 当堆栈无限大时可以使用 通不过leetcode编译器
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        return repeat((long) n) == 1L;
    }

    private long repeat(long n){
        if(n == 1L){
            return 1;
        }else if(n > Integer.MAX_VALUE){
            return 0;
        }
        long result = 0L;
        while(n > 0){
            int temp = (int)n % 10;
            result += temp * temp;
            n /= 10;
        }
        return repeat(result);
    }

    /**
     * 方法2 数学规律法
     * 当n < 10的时候只有1和7是快乐数 修改递归条件
     * 此方法可以通过 与第一种方法相比递归深度降低了一个数量级
     * @param n
     * @return
     */
    private long repeat2(long n){
        if(n == 1L || n == 7L){
            return 1;
        }else if(n < 10L){
            return 0;
        }
        long result = 0L;
        while(n > 0){
            int temp = (int)n % 10;
            result += temp * temp;
            n /= 10;
        }
        return repeat2(result);
    }

    /**
     * 方法3 快慢指针法
     *
     * 快指针执行两次 速度是慢指针的两倍
     * 当快指针=慢指针时循环结束
     * 判断结束时 指针数是否=1 只有等于1时才是快乐数
     */

    private int repeat3(int n){
        int result = 0;
        while(n > 0){
            int temp = n % 10;
            result += temp * temp;
            n /= 10;
        }
        return result;
    }

    public boolean isHappy2(int n){
        int slow = n;
        int fast = n;
        do{
            slow = repeat3(slow);
            fast = repeat3(fast);
            fast = repeat3(fast);
        }while (slow != fast);
        return slow == 1;
    }

}
