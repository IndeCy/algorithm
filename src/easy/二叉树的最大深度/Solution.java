package easy.二叉树的最大深度;


import java.util.LinkedList;

public class Solution {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private class Pair{
        private TreeNode node;
        private int dept;

        public Pair(TreeNode node, int dept) {
            this.node = node;
            this.dept = dept;
        }
    }


    /**
     * 递归实现的树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    /**
     * 迭代队列实现
     */
    public int maxDepthV2(TreeNode root){
        if(root == null){
            return 0;
        }
        LinkedList<Pair> queue = new LinkedList<>();
        int dept = 0;
        queue.addLast(new Pair(root,1));
        while(!queue.isEmpty()){
            Pair current = queue.poll();
            if(current.node != null){
                dept = Math.max(current.dept,dept);
                queue.addLast(new Pair(current.node.left,1+dept));
                queue.addLast(new Pair(current.node.right,1+dept));
            }
        }
        return dept;
    }

}
