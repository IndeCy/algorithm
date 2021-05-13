package easy.打家劫舍;

public class Solution2 {

    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int dp[] = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int n = 2; n <= nums.length; n++) {
            dp[n] = Math.max(dp[n-1],dp[n-2]+nums[n-1]);
        }
        return dp[nums.length];
    }

    public int rob2(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int pre = 0,curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = curr;
            curr = Math.max(temp,nums[i] + pre);
            pre = temp;
        }
        return curr;

    }
}
