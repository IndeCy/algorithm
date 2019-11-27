package 区域和检索数组不可变303;

public class Solution {


    /**
     * 暴力解法 直接对区间求和
     */
    class NumArray {

        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            int sum=0;
            for (; i <= j; i++) {
                sum+=nums[i];
            }
            return sum;
        }

    }

    /**
     * 缓存法 数组的累计和 最终结果是nums[j+1] - nums[i]
     */
    class NumArray2 {

        int[] nums;

        public NumArray2(int[] nums) {
            this.nums = new int[nums.length+1];
            for (int i = 1; i <this.nums.length ; i++) {
                this.nums[i] = this.nums[i-1] + nums[i-1];
            }
        }

        public int sumRange(int i, int j) {
            return nums[j+1] - nums[i];
        }

    }


}
