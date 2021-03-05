package main.牛客网.阿里篇.高效打印逆序链表;

import easy.环形链表141.ListNode;

/**
 * @Package: main.牛客网.阿里篇.高效打印逆序链表
 * @Author: chenyang
 * @Date: 2021/1/24
 * @Version: 1.0
 */
public class Solution {

    /**
     * 如果只是打印可以这么写
     * @param head
     */
    static void printNode(easy.环形链表141.ListNode head){
        if(head == null){
            return;
        }
        printNode(head.next);
        System.out.println(head.val);

    }

    /**
     * 递归返回反转后的头结点
     * @param head
     */
//    static ListNode reverse2(ListNode head){
////        if(head == null){
////            return null;
////        }
////        head.next = reverse2(head);
////        return
//    }

    /**
     * 指针向前指
     * @param head
     * @return
     */
    static ListNode reverseNode(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null){
            ListNode tempNex = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tempNex;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
//        printNode(listNode);
        ListNode listNodeR = reverseNode(listNode);
        while (listNodeR != null){
            System.out.println(listNodeR.val);
            listNodeR = listNodeR.next;
        }
    }




}
