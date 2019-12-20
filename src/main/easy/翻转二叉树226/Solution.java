package easy.翻转二叉树226;


import easy.二叉树的最小深度111.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {


    /**
     * 用递归来做 很好理解 从上至下将二叉树翻转 先序遍历
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        if(root.left != null || root.right!=null){
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            if(root.left!=null){
                invertTree(root.left);
            }
            if(root.right!=null){
                invertTree(root.right);
            }
        }
        return root;
    }


    /**
     * 用递归从下至上将二叉树翻转 后序遍历
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode leftNode = invertTree2(root.left);
        TreeNode rightNode = invertTree2(root.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }

    /**
     * 中序遍历翻转
     * @param root
     * @return
     */
    public TreeNode invertTree3(TreeNode root) {
        if(root == null){
            return null;
        }
        //递归找到最左节点
        invertTree3(root.left);
        TreeNode rightNode = root.right;
        root.right = root.left;
        root.left = rightNode;
        //遍历右节点进行交换 因为左右已经交换所以原来的右节点是现在的左节点
        invertTree3(root.left);
        return root;
    }

    /**
     * 层次遍历 利用栈 处理
     * @param root
     * @return
     */
    public TreeNode invertTree4(TreeNode root) {
       if(root == null){
           return null;
       }
       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
       while(!queue.isEmpty()){
           TreeNode temp = queue.poll();
           TreeNode right = temp.right;
           temp.right = temp.left;
           temp.left = right;
           if(temp.left != null){
               queue.offer(temp.left);
           }
           if(temp.right!=null){
               queue.offer(temp.right);
           }
       }
       return root;
    }

}
