package leetcode3.page2.middle;

import leetcode3.page2.utils.ListNode;

public class T24_swapPairs {
    /**
     * 两两交换链表中的节点
     * */
    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        ListNode newHead = pre;
        pre.next = head;
        ListNode p = head, q = head.next;
        while (p != null && q != null) {
            p.next = q.next;
            pre.next = q;
            q.next = p;

            pre = p;
            p = p.next;
            if (p != null)
                q = p.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode listNode = swapPairs(head);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
