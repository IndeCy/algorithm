package easy.相交链表160;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * 只有两个链表从相交开始都指向同一个对象才是相交而不仅仅是值相同 暴利破解法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        ListNode jiaodian = null;
        while(curA != null){
            ListNode inCurA = curA;
            while(curB!=null && inCurA != null){
                if(inCurA == curB){
                    if(jiaodian == null) {
                        jiaodian = inCurA;
                    }
                }else {
                    jiaodian = null;
                    curB = curB.next;
                    continue;
                }
                curB = curB.next;
                inCurA = inCurA.next;
            }
            if(jiaodian != null){
                return jiaodian;
            }
            curB = headB;
            curA = curA.next;
        }
        return jiaodian;
    }

    /**
     * 哈希表法 只要后面的都在a的表里存在第一个即是相交点 遍历b保证了链表判断的有序性
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        Set<ListNode> aSet = new HashSet<>();
        ListNode cur = headA;
        ListNode bb = headB;
        ListNode jiao = null;
        while(cur != null){
            aSet.add(cur);
            cur = cur.next;
        }
        while(bb != null){
            if(aSet.contains(bb)){
                if(jiao == null) {
                    jiao = bb;
                }
            }else {
                jiao = null;
            }
            bb = bb.next;

        }
        return jiao;
    }

    /**
     * 创建两个指针 pApA 和 pBpB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。
     * 当 pApA 到达链表的尾部时，将它重定位到链表 B 的头结点 (你没看错，就是链表 B); 类似的，当 pBpB 到达链表的尾部时，将它重定位到链表 A 的头结点。
     * 若在某一时刻 pApA 和 pBpB 相遇，则 pApA/pBpB 为相交结点。
     * 想弄清楚为什么这样可行, 可以考虑以下两个链表: A={1,3,5,7,9,11} 和 B={2,4,9,11}，相交于结点 9。 由于 B.length (=4) < A.length (=6)，pBpB 比 pApA 少经过 22 个结点，会先到达尾部。将 pBpB 重定向到 A 的头结点，pApA 重定向到 B 的头结点后，pBpB 要比 pApA 多走 2 个结点。因此，它们会同时到达交点。
     * 如果两个链表存在相交，它们末尾的结点必然相同。因此当 pApA/pBpB 到达链表结尾时，记录下链表 A/B 对应的元素。若最后元素不相同，则两个链表不相交。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeV3(ListNode headA, ListNode headB) {
       if(headA == null || headB == null){
           return null;
       }
       ListNode pa = headA;
       ListNode pb = headB;
       while(true){
           if(pa == pb){
               return pa;
           }
           pa = pa.next;
           pb = pb.next;
           if(pa == pb && pa == null){
               return null;
           }
           if(pa == null){
               pa = headB;
           }
           if(pb == null){
               pb = headA;
           }
       }
    }

    public ListNode getIntersectionNodeV4(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
