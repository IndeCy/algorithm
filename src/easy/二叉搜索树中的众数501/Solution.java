package easy.二叉搜索树中的众数501;

import easy.common.GenerateList;
import easy.二叉树的最小深度111.TreeNode;

import java.util.*;

public class Solution {
    public static int[] findMode(TreeNode root) {
        Map<Integer,Integer> record = new HashMap<>();
        int max = 0;
        List<Integer> res = new ArrayList<>();
        max = findMode(root,record,max);
        for (Map.Entry<Integer, Integer> next : record.entrySet()) {
            if (next.getValue() == max) {
                res.add(next.getKey());
            }
        }
        int[] ress = new int[res.size()];
        for (int j = 0; j < ress.length; j++) {
            ress[j] = res.get(j);
        }
        return ress;
    }

    /**
     * 利用先序遍历递归调用统计出现的次数
     * @param root
     * @param record
     * @param max
     * @return
     */
    static int findMode(TreeNode root,Map<Integer,Integer> record,int max){
        if(root == null){
            return max;
        }
        record.merge(root.val,1,(a,b) -> a+b);
        if(record.get(root.val) > max){
            max = record.get(root.val);
        }
        max = findMode(root.left,record,max);
        max = findMode(root.right,record,max);
        return max;
    }

    public static void main(String[] args) {
        findMode(GenerateList.getTree("[1,null,2,2]"));
    }
}
