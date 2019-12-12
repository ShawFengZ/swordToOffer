package leetcode2.list.middle;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import leetcode2.utils.ListNode;

public class T24_swapPairs {
    /**
     * 两两交换链表中的节点
     * */
    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p=head, q = head.next;
        while (q != null) {
            p.next = q.next;
            q.next = p;
            pre.next = q;
            pre = p;
            p = p.next;
            if (p != null) {
                q = p.next;
            } else {
                q = null;
            }

        }
        return newHead;
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
