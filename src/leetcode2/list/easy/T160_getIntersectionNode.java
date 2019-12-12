package leetcode2.list.easy;

import leetcode2.utils.ListNode;

public class T160_getIntersectionNode {
    /**
     * 编写一个程序，找到两个单链表相交的起始节点。
     * */
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int l1=1, l2=1;
        ListNode p1 = headA, p2 = headB;
        while (p1.next != null) {
            p1 = p1.next;
            l1++;
        }
        while (p2.next != null) {
            p2 = p2.next;
            l2++;
        }
        int cnt = l1>l2?l1-l2:l2-l1;
        p1 = headA;
        p2 = headB;
        while (cnt > 0) {
            if (l1 > l2) {
                p1 = p1.next;
            } else {
                p2 = p2.next;
            }
            cnt--;
        }
        while (p1 != null && p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(4);

        ListNode head2 = new ListNode(2);
        head2.next = head.next.next;

        ListNode listNode = getIntersectionNode(head, head2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
