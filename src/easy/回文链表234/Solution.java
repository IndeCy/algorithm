package easy.回文链表234;

import easy.环形链表141.ListNode;

import java.util.LinkedList;

public class Solution {

    /**
     * 方法1 使用队列 时间复杂度O(n) 空间复杂度O(n)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        LinkedList<ListNode> list = new LinkedList<>();
        while(head!=null){
            list.addFirst(head);
            head = head.next;
        }
        while(list.size() > 1){
            if(list.pollFirst().val != list.pollLast().val){
                return false;
            }
        }
        return true;
    }

    /**
     * 快慢指针反转链表
     * @param head
     * @return
     */
    public static boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow=head,fast=head;
        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newLastHalf = reverse(slow);
        while(newLastHalf!=null){
            if(newLastHalf.val != head.val){
                return false;
            }
            newLastHalf = newLastHalf.next;
            head = head.next;
        }
        return true;
    }

    /**
     * easy.反转链表
     * @param head
     * @return
     */
    private static ListNode reverse(ListNode head){
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

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(0);
        System.out.println(isPalindrome2(head));
    }
}
