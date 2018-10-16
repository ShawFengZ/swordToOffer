package leetcode.t23_MergeKSortedLists;

/**
 * @author zxf
 * @date 2018/10/16 15:32
 */
public class Solution23 {
    /**
     * 题目描述：
     *      整合k个已排序的链表
     * 思路：
     *      多次融合两个。
     * */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        if (lists.length==1)
            return lists[0];
        if (lists.length==2)
            return mergeTwoLists(lists[0], lists[1]);
        ListNode listNode = mergeTwoLists(lists[0], lists[1]);
        for (int i=2;i<lists.length; i++) {
            listNode = mergeTwoLists(listNode, lists[i]);
        }
        return listNode;
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        ListNode listNode = mergeKLists(lists);
        while (listNode != null) {
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }
    }
}
