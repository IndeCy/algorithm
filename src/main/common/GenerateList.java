package common;

import 二叉树的最小深度111.TreeNode;
import 环形链表141.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateList {

    public static ListNode getList(String s){
        String[] ss = s.split(",");
        ListNode head = new ListNode(Integer.valueOf(ss[0]));
        ListNode cur = head;
        for (int i = 1; i < ss.length; i++) {
            cur.next = new ListNode(Integer.valueOf(ss[i]));
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
//        ListNode head = getList("2,3,4,5,6");
//        System.out.println(head.val);

        TreeNode tree = getTree("[1,null,2,null,3,null,4,null,5]");
        System.out.println("11");
    }

    public static TreeNode getTree(String s){
        s = s.substring(1,s.length()-1);
        String[] ss = s.split(",");
        List<TreeNode> nodeList = new ArrayList<>(ss.length + 1);
        nodeList.add(null);
        for (int i = 0; i < ss.length; i++) {
            TreeNode treeNode = null;
            if(!ss[i].equals("null")) {
                treeNode = new TreeNode(Integer.parseInt(ss[i]));
            }
            nodeList.add(treeNode);
        }
        for (int i = 1,j=1; i < nodeList.size(); i++) {
            TreeNode temp = nodeList.get(i);
            if(temp == null){
                continue;
            }
            if(2*j >= nodeList.size()){
                temp.left = null;
                break;
            }else {
                temp.left = nodeList.get(2 * j);
            }
            if(2*j + 1 >= nodeList.size()) {
                temp.right = null;
                break;
            }else {
                temp.right = nodeList.get(2 * j + 1);

            }
            j++;
        }
        return nodeList.get(1);
    }

    public static char[] getCharArray(String s){
        s = s.substring(2,s.length()-2);
        String[] split = s.split("\",\"");
        char[] res = new char[split.length];
        System.arraycopy(split,0,res,0,res.length);
        return res;
    }

}
