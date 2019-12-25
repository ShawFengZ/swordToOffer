package leetcode3.page1.middle;

import leetcode3.page1.utils.ListNode;

public class T02_addTwoNumbers {
    /**
     * 两数相加
     * */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinWei = 0;
        ListNode res = new ListNode(-1);
        ListNode p = res;
        while (l1 != null && l2 != null) {
            p.next = new ListNode((l1.val+l2.val+jinWei)%10);
            p = p.next;
            jinWei = (l1.val+l2.val+jinWei)/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            p.next = new ListNode((l1.val+jinWei)%10);
            p = p.next;
            jinWei = (l1.val + jinWei)/10;
            l1 = l1.next;
        }
        while (l2 != null) {
            p.next = new ListNode((l2.val + jinWei)%10);
            p = p.next;
            jinWei = (l2.val + jinWei)/10;
            l2 = l2.next;
        }
        if (jinWei != 0) {
            p.next = new ListNode(jinWei);
        }
        return res.next;
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
