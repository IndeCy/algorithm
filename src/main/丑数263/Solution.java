package 丑数263;

public class Solution {

    /**
     * 递归解法  可以但没必要
     */
    public boolean isUgly(int num) {
        if(num <=0){
            return false;
        }
        if(num == 1){
            return true;
        }
        if(num % 2 == 0){
            num /= 2;
        }else if(num % 3 == 0){
            num /= 3;
        }else if(num % 5 == 0){
            num /= 5;
        }else {
            return false;
        }
        return isUgly(num);
    }

    /**
     * 循环就行
     */
    public boolean isUgly2(int num) {
        if(num < 1){
            return false;
        }
        while(num % 2 == 0) {
            num /= 2;
        }
        while(num % 3 == 0){
            num /= 3;
        }
        while(num % 5 == 0){
            num /= 5;
        }
        return num == 1;
    }
}
