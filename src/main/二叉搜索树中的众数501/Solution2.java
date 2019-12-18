package 二叉搜索树中的众数501;

import common.GenerateList;
import 二叉树的最小深度111.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 利用中序遍历进行递归
 */
public class Solution2 {

    static int maxTimes = 0;
    static int thisTimes = 0;
    static List<Integer> res = new LinkedList<Integer>();
    static TreeNode pre = null;
    public static int[] findMode(TreeNode root) {
        inOrder(root);
        int length = res.size();
        int[] rr = new int[length];
        for(int i = 0; i < length; i++) {
            rr[i] = res.get(i);
        }
        return rr;
    }
    public static void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        if(pre != null && pre.val == root.val) {
            thisTimes++;
        } else {
            thisTimes = 1;
        }
        if(thisTimes == maxTimes) {
            res.add(root.val);
        } else if(thisTimes > maxTimes) {
            maxTimes = thisTimes;
            res.clear();
            res.add(root.val);
        }
        pre = root;
        inOrder(root.right);
    }

    public static void main(String[] args) {
        findMode(GenerateList.getTree("[1,1,2,2,4,5,6,7,7,8]"));
    }
}
