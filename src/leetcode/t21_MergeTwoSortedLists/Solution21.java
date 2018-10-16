package leetcode.t21_MergeTwoSortedLists;

import java.util.List;

/**
 * @author zxf
 * @date 2018/10/16 14:56
 */
public class Solution21 {
    /**
     * 题目描述：
     *      将两个排序好的链表合并成一个。
     * 思路：
     *      1. 当两个链表都不空时，谁小谁就连
     *      2. 把未链完的链表连接到结果链表的后面
     * */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null && l2==null)
            return null;
        if (l1==null || l2==null) {
            if (l1 == null)
                return l2;
            else
                return l1;
        }
        ListNode ans = null;
        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ans = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ans.next = l1;
                l1 = l1.next;
                ans = ans.next;
            } else {
                ans.next = l2;
                l2 = l2.next;
                ans = ans.next;
            }
        }
        if (l1 != null)
            ans.next = l1;
        else if (l2 != null)
            ans.next = l2;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
