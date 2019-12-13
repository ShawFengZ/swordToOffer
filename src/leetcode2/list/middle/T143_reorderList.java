package leetcode2.list.middle;

import leetcode2.utils.ListNode;

public class T143_reorderList {
    /**
     * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
     * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 思路：
     * 1. 先复制逆转；
     * 2. 合并；
     * */
    private static ListNode reorderList(ListNode head){
        if(head == null) {
            return head;
        }
        ListNode p = null;
        ListNode fast = head, slow = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        ListNode q = slow;
        while (q != null) {
            ListNode tmp = new ListNode(q.val);
            tmp.next = p;
            p = tmp;
            q = q.next;
        }
        q = head;
        while (p != null && q != null) {
            ListNode pp = p.next;
            p.next = q.next;
            q.next = p;
            q = q.next.next;
            p = pp;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next= new ListNode(3);
        /*head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);*/

        ListNode listNode = reorderList(head);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
