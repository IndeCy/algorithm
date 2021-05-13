package easy.二叉树的所有路径257;

import easy.二叉树的最小深度111.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {

    /**
     * 方法1 递归解法
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        NFS(root,"",res);
        return res;
    }

    private void NFS(TreeNode node,String path,List<String> paths){
        if(node != null){
            path += node.val;
            if(node.left == null && node.right == null){
                paths.add(path);
            }else {
                path += "->";
                NFS(node.left,path,paths);
                NFS(node.right,path,paths);
            }
        }

    }

    /**
     * 方法2 迭代写法
     * @param root
     * @return
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        if(root==null){
            return Collections.EMPTY_LIST;
        }
        List<String> res = new ArrayList<>();
        Stack<NodeInfo> stack = new Stack<>();
        NodeInfo nodeInfo = new NodeInfo();
        nodeInfo.node = root;
        nodeInfo.path = ""+root.val;
        stack.push(nodeInfo);
        while(!stack.empty()){
            NodeInfo pop = stack.pop();
            if(pop.node.left == null && pop.node.right == null){
                res.add(pop.path);
            }
            if(pop.node.left != null){
                NodeInfo nodeInfo1 = new NodeInfo();
                nodeInfo1.node = pop.node.left;
                nodeInfo1.path = pop.path + "->" + pop.node.left.val;
                stack.push(nodeInfo1);
            }
            if(pop.node.right != null){
                NodeInfo nodeInfo1 = new NodeInfo();
                nodeInfo1.node = pop.node.right;
                nodeInfo1.path = pop.path + "->" + pop.node.right.val;
                stack.push(nodeInfo1);
            }
        }
        return res;
    }

    class NodeInfo{
        TreeNode node;
        String path;
    }


}
