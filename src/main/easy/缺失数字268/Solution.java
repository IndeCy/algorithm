package easy.缺失数字268;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {


    /**
     * 虽然可以 但是过不了用例 空间复杂度太高
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int[] res = new int[1024];
        for (int i: nums
             ) {
            res[i] = 1;
        }
        return Arrays.binarySearch(res,0);
    }

    //法1  先排序  完成后在判断第一位==0 最后一位==最大值 其余的只可能缺失在中间
    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length ;i++){
            if(nums[i] != i){
                return i;
            }
        }
        //题中说的是n个数 n一定是数组的最后一位 且数组下标为n-1时 值为n才是完整的 否则就缺少n的值
        if(nums[nums.length -1] != nums.length){
            return nums.length;
        }
        return -1;
    }
    //法2  HashSet contains 来判断是否存在
    public int missingNumber2(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            if(!hashSet.contains(i)){
                return i;
            }
        }
        if(!hashSet.contains(nums.length)){
            return nums.length;
        }
        return -1;

    }
    //法3 位运算 任何一个数抑或自己都为0
    public int missingNumber3(int[] nums) {
        int sum1 =0, sum2 = 0;
        for (int num : nums) {
            sum1 ^= num;
        }
        for (int i = 0; i <= nums.length ; i++) {
            sum2 ^= i;
        }
        return sum1 ^ sum2;
    }

    public int missingNumber3_1(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    //法4 高斯求和公式  这个想到了 感觉会溢出
    public static int missingNumber4(int[] nums) {
        int sum = nums.length * (nums.length + 1)/2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public static int missingNumberPro(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(missingNumber4(nums));
    }
}
