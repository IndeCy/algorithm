package 二叉树自底向上层次遍历;



import java.util.*;

public class Solution {

    private class Pair{
        TreeNode val;
        int depth;

        public Pair(TreeNode var, int depth) {
            this.val = var;
            this.depth = depth;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        List<List<Integer>> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode current = queue.poll();
                temp.add(current.val);
                if(current.left != null){
                    queue.addLast(current.left);
                }
                if(current.right != null){
                    queue.addLast(current.right);
                }
            }
            result.add(temp);
        }
        Collections.reverse(result);
        return result;

    }


    /**
     * 自己写的解决方案 bug:需要添加的数字间隔null时会导致将他们视为不同层级的节点
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottomOwn(TreeNode root) {
        if(root == null){
            return null;
        }
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(root,0));
        List<List<Integer>> result = new ArrayList<>();
        while(!queue.isEmpty()){
            Pair current = queue.poll();
            TreeNode head = current.val;
            if(head == null){
                continue;
            }
            List<Integer> item = new ArrayList<>();
            item.add(head.val);
            queue.addLast(new Pair(head.left,current.depth + 1));
            queue.addLast(new Pair(head.right, current.depth + 1));
            Pair it;
            TreeNode itVal;
            while((it = queue.peek()) != null && (itVal = it.val) != null && it.depth == current.depth){
                item.add(itVal.val);
                queue.addLast(new Pair(itVal.left,current.depth + 1));
                queue.addLast(new Pair(itVal.right, current.depth + 1));
                queue.removeFirst();
            }
            result.add(item);
        }
        Collections.reverse(result);
        return result;
    }
}
