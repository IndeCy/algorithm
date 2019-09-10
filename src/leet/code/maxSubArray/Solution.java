package leet.code.maxSubArray;

public class Solution {
    public static void main(String[] args) {
        int[] a = {-3,-1,-4};
        int[] b=  {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArrayV5(b));
    }
    public static int maxSubArray(int[] nums) {
        int sum =nums[0], temp=0;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]<0){
                temp = temp > sum ? temp : sum;
            }
            sum += nums[i];
            if(sum<0){
                sum = nums[i];
            }

        }
        return temp > sum ? temp : sum;
    }

    public static int maxSubArrayV5(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            }
            else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
