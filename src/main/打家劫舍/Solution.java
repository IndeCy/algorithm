package 打家劫舍;

public class Solution {

    /**
     * 分析题意
     * 我们只需要保证 取 （之前的最大值加上现在的数，现在最大值）的最大值当作当前的最大值
     * 此算法是做了最大优化不太好理解
     */
    public int rob(int[] nums) {
        int preMax = 0,currMax = 0;
        for(int a : nums){
            int temp = currMax;
            currMax = Math.max(a+preMax,currMax);
            preMax = temp;
        }
        return currMax;
    }

    /**
     * 动态规划算法2
     * 标准动态规划 思想和第一种方式相同
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] res = new int[nums.length+1];
        res[0] = 0;
        res[1] = nums[0];
        /**
         * 为什么用i <= nums.length 因为取得是nums[i-1]的值 保证取到最后一位
         */
        for (int i = 2; i <= nums.length; i++) {
            res[i] = Math.max(res[i-1],res[i-2]+nums[i-1]);
        }
        return res[nums.length];
    }

    public static void main(String[] args) {
        rob2(new int[]{1,2,3,1});
    }
}
