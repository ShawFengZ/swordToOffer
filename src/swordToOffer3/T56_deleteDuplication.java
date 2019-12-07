package swordToOffer3;

import swordToOffer3.utils.ListNode;

public class T56_deleteDuplication {
    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
     * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     *
     * 1. 两个指针，p往后移动找到需要删除的节点；
     * 2. q从p的后面往后找到不同的节点
     * */
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;
        ListNode p = newHead;
        while (p.next!= null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                ListNode tmp = p.next.next;
                while (tmp!= null && tmp.val == p.next.val) {
                    tmp = tmp.next;
                }
                p.next = tmp;
            } else {
                p = p.next;
            }
        }
        return newHead.next;
    }
}
