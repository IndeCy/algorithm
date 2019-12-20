package easy.路径总和III437;

import easy.common.GenerateList;
import easy.二叉树的最小深度111.TreeNode;

public class Solution3 {

    public static int pathSum(TreeNode root, int sum) {
        return pathSum(root, sum, new int[1000], 0);
    }

    /**
     *
     * @param root
     * @param sum
     * @param array 保存路径 依次往后的节点都是前面节点的子节点
     * @param p 递归深度或者说是树的深度
     * @return
     */
    public static int pathSum(TreeNode root, int sum, int[] array, int p) {
        if (root == null) {
            return 0;
        }
        int tmp = root.val;
        int n = root.val == sum ? 1 : 0;
        //循环往前依次累加来判断当前路径所有值
        for (int i = p - 1; i >= 0; i--) {
            tmp += array[i];
            if (tmp == sum) {
                n++;
            }
        }
        array[p] = root.val;
        int n1 = pathSum(root.left, sum, array, p + 1);
        int n2 = pathSum(root.right, sum, array, p + 1);
        return n + n1 + n2;
    }

    public static void main(String[] args) {
        System.out.println(pathSum( GenerateList.getTree("[5,4,8,11,null,13,4,7,2,null,null,5,1]"),22));
    }
}
