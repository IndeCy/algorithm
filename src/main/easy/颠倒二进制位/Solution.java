package easy.颠倒二进制位;

public class Solution {

    /**
     * 二进制位运算来做
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            //1.将原数一位一位右移出来
            int temp = n >> i;
            //2.与上1 将右移的数取出来
            temp = temp & 1;
            //3.再将取出来的数左移 i 个单位
            temp = temp << (31-i);
            //4.最后再用一个新数将它们组装起来
            result |= temp;
        }
        return result;
    }
}
