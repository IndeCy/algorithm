package easy.路径总和III437;

import easy.common.GenerateList;
import easy.二叉树的最小深度111.TreeNode;

/**
 * 双递归处理
 */
public class Solution2 {

    //定义全局变量来存储结果数量
    static int result = 0;

    public static int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        pathSum(root,sum,0);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return result;
    }

    //递归计算从当前节点往下的所有路径和
    private static void pathSum(TreeNode root,int sum,int tempSum){
        if(root == null){
            return ;
        }
        tempSum = tempSum + root.val;
        if(tempSum == sum){
            result++;
        }
        pathSum(root.left,sum,tempSum);
        pathSum(root.right,sum,tempSum);
    }

    public static void main(String[] args) {
        TreeNode root = GenerateList.getTree("[1,null,2,null,3,null,4,null,5]");
        System.out.println(pathSum(root,3));
    }
}
