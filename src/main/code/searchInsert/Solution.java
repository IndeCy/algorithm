package main.code.searchInsert;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,3,4,4};
        System.out.println(searchInsert(nums,5)+"");
    }
    public static int searchInsert(int[] nums, int target) {
        if(nums.length==0){
            return 0;
        }
        for(int i= 0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=target){
                return i;
            }
        }
        return nums.length;
    }
}
