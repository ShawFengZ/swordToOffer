package leetcode2.list.hard;

import leetcode2.utils.ListNode;

public class T1019_nextLargerNodes {
    /**
     * 链表中的下一个更大的节点
     *
     * 方法一: 暴力法，O(n^2)
     * 方法二：使用栈
     * 方法三：dp
     * */
    private static int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        int[] res = new int[len];
        int cnt = 0;
        p = head;
        while (p.next != null) {
            ListNode tmp = p.next;
            while (tmp != null && tmp.val <= p.val) {
                tmp = tmp.next;
            }
            if (tmp != null) {
                res[cnt++] = tmp.val;
            } else {
                cnt++;
            }
            p = p.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(7);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);

        int[] ints = nextLargerNodes(head);
        for (int i: ints) {
            System.out.print(i + " ");
        }
    }
}
