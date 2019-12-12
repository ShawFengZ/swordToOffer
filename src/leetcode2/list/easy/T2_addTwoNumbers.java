package leetcode2.list.easy;

import leetcode2.utils.ListNode;

public class T2_addTwoNumbers {

    /**
     * 两数相加
     *
     * (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 7 -> 0 -> 8
     *
     * 1. 使用栈(比较简单)
     * 2. 指针法
     * */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int jinWei = 0;
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + jinWei;
            p.next = new ListNode(sum % 10);
            jinWei = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }

        while (l1 != null) {
            int sum = l1.val + jinWei;
            p.next = new ListNode(sum % 10);
            jinWei = sum / 10;
            l1 = l1.next;
            p = p.next;
        }
        while (l2 != null) {
            int sum = l2.val + jinWei;
            p.next = new ListNode(sum%10);
            jinWei = sum/10;
            l2 = l2.next;
            p = p.next;
        }
        if (jinWei != 0) {
            p.next = new ListNode(jinWei);
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

}
