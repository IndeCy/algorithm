package common;

import 环形链表141.ListNode;

import java.util.Arrays;

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
        ListNode head = getList("2,3,4,5,6");
        System.out.println(head.val);
    }
}
