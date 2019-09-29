package main.code.Merge;

public class MergeList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //创建一个头指针指向头节点
        ListNode dummyHead = new ListNode(0);
        //操作指针从头节点往后移动
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        //返回头指针往后遍历
        return dummyHead.next;
    }

}
