package leetcode2.list.middle;

import leetcode2.utils.ListNode;

import java.util.List;
import java.util.Stack;

public class T234_isPalindrome {
    /**
     * 判断链表是否是回文链表
     *
     * 反转链表后比较
     *
     * 最优解法:
     * 快慢指针解法：
     *      1. 快慢指针往后找，快指针到队尾的时候，慢指针刚好到中间；
     *      2. 慢指针往前更新的时候，同时更新指针的方向；
     *      3. 比较两者的数值是否相等
     * */
    private static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        p = head;
        while (!stack.isEmpty()) {
            if (p.val != stack.pop()) {
                return false;
            }
            p =p.next;
        }
        return true;
    }

    private static boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prePre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prePre;
            prePre = pre;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        boolean palindrome = isPalindrome(head);
        System.out.println(palindrome);
    }
}
