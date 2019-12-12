package leetcode2.list.middle;

import leetcode2.utils.ListNode;

public class T19_removeNthFromEnd {
    /**
     * 删除链表的倒数第n个节点
     * */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n<=0) {
            return head;
        }
        ListNode p = head;
        while (p != null && n > 0) {
            p = p.next;
            n--;
        }
        //注意这里
        if (p == null) {
            if (n==0)
                return head.next;
            else
                return null;
        }
        ListNode q = head;
        while (p.next != null) {
            q = q.next;
            p = p.next;
        }
        q.next = q.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        /*head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);*/
        ListNode listNode = removeNthFromEnd(head, 1);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
