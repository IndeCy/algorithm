package easy.相对名次506;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 2N的空间复杂度 垃圾 暴力破解法 垃圾
     * @param nums
     * @return
     */
    public String[] findRelativeRanks(int[] nums) {
        Map<Integer,String> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i+"");
        }
        int[] temp = Arrays.copyOf(nums,nums.length);
        Arrays.sort(temp);
        for (int i = temp.length - 1; i >=0; i--) {
            if(i==nums.length-1){
                map.put(temp[i],"Gold Medal");//"Gold Medal", "Silver Medal", "Bronze Medal"
            }else if(i==nums.length-2){
                map.put(temp[i],"Silver Medal");
            }else if(i==nums.length-3){
                map.put(temp[i],"Bronze Medal");
            }else {
                map.put(temp[i],temp.length-i+"");
            }
        }
        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }

    /**
     * 大佬动态规划 牛批
     * @param nums
     * @return
     */
    public String[] findRelativeRanks2(int[] nums) {
        String[] res = new String[nums.length];
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] dp = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[nums[i]] = i + 1;
        }

        for (int i = max, rank = 1; i >= 0; i--) {
            if (dp[i] > 0) {
                switch (rank) {
                    case 1:
                        res[dp[i] - 1] = "Gold Medal";
                        break;
                    case 2:
                        res[dp[i] - 1] = "Silver Medal";
                        break;
                    case 3:
                        res[dp[i] - 1] = "Bronze Medal";
                        break;
                    default:
                        res[dp[i] - 1] = Integer.toString(rank);
                        break;
                }
                rank++;
            }
        }
        return res;
    }
}
