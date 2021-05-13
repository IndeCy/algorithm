package easy.路径总和III437;

import easy.common.GenerateList;
import easy.二叉树的最小深度111.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    //定义全局变量来存储结果数量
    static int result = 0;

    //新建集合储存所有节点
    static List<TreeNode> nodeList = new ArrayList<>();

    public static int pathSum(TreeNode root, int sum) {
        nodeList(root);
        //循环去将每个节点都当成一个头结点来处理 因为不会回溯哈哈哈
        for (TreeNode node:nodeList) {
            pathSum(node,sum,0);
        }
        return result;
    }

    //递归将所有节点放到集合中
    private static void nodeList(TreeNode root){
        if(root == null){
            return;
        }
        nodeList.add(root);
        nodeList(root.left);
        nodeList(root.right);
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
        TreeNode root = GenerateList.getTree("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        System.out.println(pathSum(root,22));
    }
}
