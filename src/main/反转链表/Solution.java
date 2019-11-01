package 反转链表;

import 环形链表141.ListNode;

import java.util.LinkedList;

public class Solution {

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
