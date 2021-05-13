package easy.环形链表141;

public class Solution {


    /**
     * 双指针一次解决
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode b = head;
        ListNode cur = head;
        while(b!=null && cur != null && b.next != null){
            b = b.next.next;
            cur = cur.next;
            if(b == cur){
                return true;
            }

        }
        return false;
    }
}
