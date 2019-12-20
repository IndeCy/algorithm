package easy.数字的补数476;

public class Solution {

    /**
     * 用抑或运算
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        int i= 0,res =0,temp=num;
        while(temp > 0){
            //这一步可以优化成位运算
            res+=Math.pow(2,i);
            i++;
            temp >>>= 1;
        }
        return res ^ num;
    }

    public static int findComplement2(int num) {
        int res =1,temp=num;
        while(temp > 0){
            //这一步可以优化成位运算
            res<<=1;
            temp >>>= 1;
        }
        return (res-1) ^ num;
    }

    public static void main(String[] args) {
        findComplement(5);
    }
}
