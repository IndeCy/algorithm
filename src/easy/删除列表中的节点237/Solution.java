package easy.删除列表中的节点237;

import easy.环形链表141.ListNode;

public class Solution {

    /**
     * 这题是脑筋急转弯吗  没有链表入口
     * 官方题解：将下一个节点的值赋予它 然后删除下一个节点 真有你的
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
