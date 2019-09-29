package 二叉树的最小深度111;

public class Solution {

    public int minDepth(TreeNode root) {

        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int minDepth = Integer.MAX_VALUE;
        if(root.left != null){
            minDepth = Math.min(minDepth,minDepth(root.left));
        }
        if(root.right != null){
            minDepth = Math.min(minDepth,minDepth(root.right));
        }
        return minDepth;
    }

    public int minDepthV2(TreeNode root){
        //节点为空返回0
        if(root == null) return 0;
        //节点为叶子节点，即左右子树都为空，返回深度1
        if(root.left == null && root.right == null) return 1;
        int left = minDepthV2(root.left);
        int right = minDepthV2(root.right);
        //当前节点有且只有一个子节点为空，则它不是叶子节点，返回不为空的节点的深度+1
        if(left == 0 || right == 0){
            return left + right + 1;
        }
        //当前节点的左右节点都不为空，返回较小的高度+1
        return Math.min(left,right) + 1;

    }


}
