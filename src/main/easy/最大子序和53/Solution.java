package easy.最大子序和53;

/**
 * @Package: easy.最大子序和53
 * @Author: chenyang
 * @Date: 2021/1/6
 * @Version: 1.0
 */
public class Solution {
    /**
     * 对比当前数值和之前的和如果之前的和小于0则舍弃否则加上当前值作为当前和，并与之前和对比，取较大的作为最大和
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(num, pre + num);
            maxAns = Math.max(pre, maxAns);
        }
        return maxAns;
    }

    public static void main(String[] args) {

    }

}
