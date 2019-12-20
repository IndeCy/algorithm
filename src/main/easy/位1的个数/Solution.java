package easy.位1的个数;

public class Solution  {

    /**
     * 还是用位运算来做 将原数右移并&1取出数并计算个数
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int temp = n >> i;
            if((temp & 1) == 1){
                count++;
            }
        }
        return count;
    }
}
