package easy.路经总和是否存在112;

import java.util.LinkedList;

public class Solution {

    /**
     * 递归的方式 自己的写法
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null && root.val == sum){
            return true;
        }
        boolean left = false;
        boolean right = false;
        if(root.left != null){
            left = hasPathSum(root.left,sum - root.val);
        }
        if(root.right != null && !left){
            right = hasPathSum(root.right,sum - root.val);
        }
        return left || right;
    }

    /**
     * 递归官方简略写法
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSumV2(TreeNode root, int sum) {
        if (root == null)
            return false;
        sum -= root.val;
        if ((root.left == null) && (root.right == null))
            return (sum == 0);
        return hasPathSumV2(root.left, sum) || hasPathSumV2(root.right, sum);
    }

    /**
     * 迭代法
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSumV3(TreeNode root,int sum){
        if(root == null){
            return false;
        }
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        LinkedList<Integer> sumList = new LinkedList<>();
        nodeList.add(root);
        sumList.add(sum);
        while(!nodeList.isEmpty()){
            TreeNode current = nodeList.pollLast();
            Integer leave = sumList.pollLast();
            if(root.val - leave == 0 && current.left == null && current.right == null){
                return true;
            }
            if(current.left != null){
                nodeList.add(current.left);
                sumList.add(leave - current.left.val);
            }
            if(current.right != null){
                nodeList.add(current.right);
                sumList.add(leave - current.right.val);
            }
        }
        return false;
    }


    /**
     * 迭代官方写法
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSumV4(TreeNode root, int sum) {
        if (root == null)
            return false;

        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<Integer> sum_stack = new LinkedList();
        node_stack.add(root);
        sum_stack.add(sum - root.val);

        TreeNode node;
        int curr_sum;
        while ( !node_stack.isEmpty() ) {
            node = node_stack.pollLast();
            curr_sum = sum_stack.pollLast();
            if ((node.right == null) && (node.left == null) && (curr_sum == 0))
                return true;

            if (node.right != null) {
                node_stack.add(node.right);
                sum_stack.add(curr_sum - node.right.val);
            }
            if (node.left != null) {
                node_stack.add(node.left);
                sum_stack.add(curr_sum - node.left.val);
            }
        }
        return false;
    }


}
