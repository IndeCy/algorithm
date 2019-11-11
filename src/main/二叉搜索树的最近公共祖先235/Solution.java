package 二叉搜索树的最近公共祖先235;

import 二叉树的最小深度111.TreeNode;

import java.util.Queue;

public class Solution {


    /**
     * 二叉搜索树的最近公共祖先 用递归
     * 节点 NN 左子树上的所有节点的值都小于等于节点 NN 的值
     * 节点 NN 右子树上的所有节点的值都大于等于节点 NN 的值
     * 左子树和右子树也都是 BST
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //利用二叉搜索树的性质 同在左子树就在左子树往下递归
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        //同在右子树 就在右子树往下递归
        }else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        //否则最深的公共祖先就找到了
        }else{
            return root;
        }
    }

    /**
     * 不使用递归通过迭代来解决
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        while(root.left != null || root.right != null){
            if(p.val == root.val || q.val == root.val){
                return p.val == root.val ? p : q;
            }
            if(p.val < root.val && q.val < root.val){
                root = root.left;
            }else if(p.val > root.val && q.val > root.val){
                root = root.right;
            }else {
                return root;
            }
        }
        return null;
    }

}
