package leetcode2.list.easy;

import leetcode2.utils.ListNode;

public class T61_rotateRight {
    /**
     * 旋转链表
     *
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     *
     * 考虑k=0的情况
     * */
    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        k = k%len;
        if (k == 0) {
            return head;
        }
        int cnt = len-k-1;
        p = head;
        while (cnt > 0) {
            p = p.next;
            cnt--;
        }
        ListNode newHead = p.next;
        p.next = null;
        p = newHead;
        while (p.next != null) {
            p = p.next;
        }
        p.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        /*head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);*/
        ListNode listNode = rotateRight(head, 4);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
