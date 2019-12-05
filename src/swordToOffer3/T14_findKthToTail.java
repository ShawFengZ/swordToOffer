package swordToOffer3;

import swordToOffer3.utils.ListNode;

public class T14_findKthToTail {
    /**
     * 题目：
     * 输入一个链表，输出该链表中倒数第k个结点。
     *
     * 思路:
     * 1. 往后移动，同时k--
     * */
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 0) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        if (k > 0) { //说明没有找到这个节点
            return null;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
