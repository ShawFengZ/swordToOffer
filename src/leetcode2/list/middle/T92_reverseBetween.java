package leetcode2.list.middle;

import leetcode2.utils.ListNode;

public class T92_reverseBetween {

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * */
    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m >= n) {
            return head;
        }
        ListNode p = head;
        ListNode end, start;//前一段的尾节点和后一段的头节点
        ListNode rs, re;
        int cnt = 1;
        while (p != null && p.next != null) {
            if (cnt+1==m) {
                end = p;
                rs = p.next;
            }

        }
        return null;
    }
}
