package leetcode2.list.middle;

import leetcode2.utils.ListNode;

public class T86_partition {
    /**
     * 分隔链表
     *
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
     * 你应当保留两个分区中每个节点的初始相对位置。
     *
     * 思路：
     * 1. p, 遍历找到p.next.val >= x
     * 2. q, 遍历找到q.next.val < x
     * 3. 交换两个节点的位置
     * */
    private static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = new ListNode(0);
        ListNode newHeadPre = p;
        p.next = head;
        while (p.next != null && p.next.val < x) {
            p = p.next;
        }
        ListNode q = p.next;
        while (q != null && q.next != null) {
            if (q.next.val < x) {
                ListNode tmp = q.next;
                q.next = tmp.next;
                tmp.next = p.next;
                p.next = tmp;
                p = p.next;
            } else {
                q = q.next;
            }
        }
        return newHeadPre.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        /*head.next.next= new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);*/

        ListNode listNode = partition(head, 2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
