package easy.相交链表160;

public class Main {

    public static void main(String[] args) {
       ListNode headA = new ListNode(4);
       headA.next = new ListNode(1);
       ListNode l8 = new ListNode(8);
       ListNode l4 = new ListNode(4);
       ListNode l5 = new ListNode(5);
       headA.next.next = l8;
       headA.next.next.next = l4;
       headA.next.next.next.next = l5;

       ListNode headB = new ListNode(5);
       headB.next = new ListNode(0);
       headB.next.next = new ListNode(1);
       headB.next.next.next = l8;
       headB.next.next.next.next = l4;
       headB.next.next.next.next.next = l5;

       ListNode res = new Solution().getIntersectionNodeV3(headA,headB);

    }
}
