package easy.左子叶之和404;


import easy.二叉树的最小深度111.TreeNode;

public class Solution {
    /**
     * 递归处理
     * 判断传入节点的左子节点是否是叶子节点 如果是就将结果加上节点的值
     * 否则向下遍历 先遍历左子节点 再遍历右子节点
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        if(root.left!=null && root.left.left == null && root.left.right == null){
            sum += root.left.val;
        }else {
            sum += sumOfLeftLeaves(root.left);
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public int sumOfLeftLeaves2(TreeNode root){
        if(root == null){
            return 0;
        }
        int sum=0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            sum += root.left.val;
        }else{
            sum += sumOfLeftLeaves2(root.left);
        }
        sum += sumOfLeftLeaves2(root.right);
        return sum;
    }
}
