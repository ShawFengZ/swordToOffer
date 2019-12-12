package leetcode2.list.easy;

import leetcode2.utils.ListNode;

public class T203_removeElements {
    /**
     * 删除链表中等于给定值 val 的所有节点。
     * */
    private static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        while (head!=null && head.val == val) {
            head = head.next;
        }
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.next.val == val) {
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
        head.next.next= new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        ListNode listNode = removeElements(head, 6);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
