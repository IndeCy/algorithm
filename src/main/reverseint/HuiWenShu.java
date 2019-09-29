package reverseint;

/**
 * @author chenyang
 */
public class HuiWenShu {
    public static void main(String[] args) {
        Solution(121);
    }

    public static boolean Solution(int x){
        int rev = 0;
        while(x!=0){
            int pop = x%10;
            x/=10;
            if(rev>Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop>7)){
                return false;
            }
            if(rev<Integer.MIN_VALUE/10 || (rev ==Integer.MIN_VALUE/10 && pop<-8)){
                return false;
            }
            rev = rev*10 + pop;
        }

        return x == rev;
    }

    /**
     * 官方解答回文数字
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        int rev = 0;

        //数字小于0 或者最后一位为0 恒返回false
        if(x<0||x%10==0 && x!=0){
            return false;
        }
        //只处理反转一半的数字 这样的好处是不用处理溢出
        while(rev<x){
            rev = rev*10 + x%10;
            x/=10;
        }
        return x == rev||rev/10 == x;
    }
}
