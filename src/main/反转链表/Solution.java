package 反转链表;

import 环形链表141.ListNode;

import java.util.LinkedList;

public class Solution {

    /**
     * 指针向前指法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode tempNext = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tempNext;
        }
        return pre;
    }

    /**
     * 用外部栈处理的解法 内存超出限制
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        LinkedList<ListNode> list = new LinkedList<>();
        list.addFirst(null);
        while(head!=null){
            list.addFirst(head);
            head= head.next;
        }
        ListNode res = list.peekFirst();
        int i = 0;
        while(i++ < list.size()){
            ListNode first = list.pollFirst();
            first.next = list.peekFirst();
        }
        return res;
    }
}
