package 移动零283;

public class Solution {

    /**
     * 暴力解决 将0与它后面第一个不为0的数交换  O(n2) O(1)
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                for (int j = i +1; j < nums.length; j++) {
                    if(nums[j] != 0){
                        int temp = nums[j];
                        nums[j] = 0;
                        nums[i] = temp;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 双指针法 O(n) O(1)
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int slow = 0,fast = 0;
        while(fast < nums.length){
            if(nums[fast] != 0){
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        while(slow < nums.length){
            nums[slow++] = 0;
        }
    }

    /**
     * 双指针优化版 将快指针扫过的地方都置为0 不需要做二次填充
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        int slow = 0,fast = 0;
        while(fast < nums.length){
            if(nums[fast] != 0){
                int temp = nums[fast];
                nums[fast] = 0;
                nums[slow++] = temp;
            }
            fast++;
        }

    }
}
