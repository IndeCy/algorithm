package easy.环形链表141;

public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }
    public ListNode(int x,ListNode next) {
        val = x;
        this.next = next;
    }
}
