package leetcode2.list.easy;

import leetcode2.utils.ListNode;

public class T83_deleteDuplicates {
    /**
     * 删除链表中重复的元素
     *
     * 使每个元素仅出现一次
     * */
    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == p.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(4);

        ListNode listNode = deleteDuplicates(head);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
