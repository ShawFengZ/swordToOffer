package swordToOffer3;

import swordToOffer3.utils.ListNode;

public class T36_findFirstCommonNode {
    /**
     * 输入两个链表，找出它们的第一个公共结点。
     *
     * 思路：
     * 1. 分别计算两个链表的长度l1, l2;
     * 2. 计算差值l1-l2
     * 3. 比较长的那个先走l1-l2
     * 4. 相遇则返回那个节点
     * */
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int l1 = 0, l2 = 0;
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != null) {
            l1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            l2++;
            p2 = p2.next;
        }
        if (l1 > l2) {
            return getCommonNode(pHead1, pHead2, l1-l2);
        } else {
            return getCommonNode(pHead2, pHead2, l2-l1);
        }
    }

    /**
     * l1>l2
     * */
    private static ListNode getCommonNode(ListNode l1, ListNode l2, int cnt){
        while (cnt > 0) {
            cnt--;
            l1 = l1.next;
        }
        while (l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }
}
