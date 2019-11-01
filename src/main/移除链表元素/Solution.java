package 移除链表元素;

import 环形链表141.ListNode;

public class Solution {

    /**
     * 定义一个虚拟节点 不需要考虑头节点不符合条件的特殊情况
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre.next !=null){
            if(pre.next.val == val){
                pre.next = pre.next.next;
            }else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        head.next = new ListNode(6);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next = new ListNode(8);

        ListNode res = removeElements(head,6);
        System.out.println(res.val);
    }
}
