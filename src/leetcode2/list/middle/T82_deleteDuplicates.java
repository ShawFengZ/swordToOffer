package leetcode2.list.middle;

import leetcode2.utils.ListNode;

public class T82_deleteDuplicates {
    /**
     * 删除链表中的重复节点
     *
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * */
    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        ListNode newHeadPre = pre;
        pre.next = head;
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                ListNode tmp = p.next;
                while (tmp != null && tmp.val == p.val) {
                    tmp = tmp.next;
                }
                pre.next = tmp;
                p = tmp;
            } else {
                pre = p;
                p = p.next;
            }
        }
        return newHeadPre.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        /*head.next.next= new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(6);*/

        ListNode listNode = deleteDuplicates(head);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
