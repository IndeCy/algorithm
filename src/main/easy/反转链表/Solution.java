package easy.反转链表;

import easy.common.GenerateList;
import easy.环形链表141.ListNode;

import java.util.LinkedList;

public class Solution {

    /**
     * 指针向前指法
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
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
     * 官方题解递归法
     * 思想：链表 n1,n2,n2.....,nk,nk+1.....,nm
     * 假设nk -> nm都已经被反转完成 此时我们处在nk的位置 应该怎么做
     * 很显然 将nk.next.next = nk
     * 需要注意一点当k到达头节点的时候要将next指向null
     * @param head
     * @return
     */
    public static ListNode reverseList3(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode head = GenerateList.getList("1,2,3,4,5,6");
        System.out.println(head.val);
//        ListNode newHead = reverseList3(head);
//        System.out.println(newHead.val);
        reverseList22(head);
        System.out.println("sss");

    }


    /**
     * 与 reverseList3 相比较不会返回尾结点 本质上还是实现了翻转 解释了为什么要返回p节点
     * @param head
     */
    static void reverseList22(ListNode head){
        if(head == null || head.next == null){
            return;
        }
        reverseList22(head.next);
        head.next.next = head;
        head.next = null;
        //为什么return temp？temp是前一个反转好的节点
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
