package 找到数组中所有消失的数字448;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {


    /**
     * 非常妙的解法
     * 数组中的数字对应自己的下标应该是数字的绝对值 -1
     * 我们把对应下标都设为负数，最后遍历数组正数的下标+1就是缺少的值
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i : nums){
            int idx = Math.abs(i) - 1;
            nums[idx] = -Math.abs(nums[idx]);
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                res.add(i+1);
            }
        }
        return res;

    }

    public static void main(String[] args) {
//        findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        findDisappearedNumbers(new int[]{1,1,2,2});
    }
}
