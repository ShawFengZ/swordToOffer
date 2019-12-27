package leetcode3.page1.middle;

import leetcode3.page1.utils.ListNode;

public class T19_removeNthFromEnd {
    /**
     * 删除链表的倒数第n个节点
     * */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        ListNode q = new ListNode(-1);
        q.next =  head;
        ListNode newHead = q;
        ListNode p = newHead;
        while (p!= null && n > 0) {
            p = p.next;
            n--;
        }
        if (n > 0) {
            return null;
        }
        while (p!= null && p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode listNode = removeNthFromEnd(head, 4);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
