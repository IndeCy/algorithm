package easy.完美数507;

/**
 * @Package: easy.完美数507
 * @Author: chenyang
 * @Date: 2021/1/6
 * @Version: 1.0
 */
public class Solution {

    public static boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if(num % i == 0){
                sum += i;
                //同时加上它的另一个因子 但是注意排除整开方数的本身
                if(i * i != num){
                    sum += num / i;
                }
            }
        }
        return sum - num == num;
    }


    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(6));
    }

}
