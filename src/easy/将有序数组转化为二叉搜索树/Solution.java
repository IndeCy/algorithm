package easy.将有序数组转化为二叉搜索树;

public class Solution {


    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length <= 0)
            return null;
        return sortedArrayToBSTCore(nums,0,nums.length-1);
    }
    public TreeNode sortedArrayToBSTCore(int[] nums,int start ,int end) {
        if(start > end)
            return null;
        int min = start+(end-start)/2;
        TreeNode root = new TreeNode(nums[min]);
        root.left = sortedArrayToBSTCore(nums,start,min-1);
        root.right = sortedArrayToBSTCore(nums,min+1,end);
        return root;
    }

}
