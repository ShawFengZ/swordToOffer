package swordToOffer3;

import swordToOffer3.utils.ListNode;

public class T15_reverseList {
    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     * 1. p, q, r
     * 2. q.next = p; p = q; q = r; r = r.next;
     * */
    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = null, q = head, r = head.next;
        while (r != null) {
            q.next = p;
            p = q;
            q = r;
            r = r.next;
        }
        q.next = p;
        return q;
    }
}
