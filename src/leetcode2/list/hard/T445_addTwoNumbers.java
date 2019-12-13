package leetcode2.list.hard;

import com.sun.org.apache.bcel.internal.generic.NEW;
import leetcode2.utils.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class T445_addTwoNumbers {
    /**
     * 两数相加II
     * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出: 7 -> 8 -> 0 -> 7
     *
     * 方法一：双栈，最直接的方法
     * 方法二：使用双端队列
     * */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }

        int val = stack1.pop().val + stack2.pop().val;
        int jinWei = val/10;
        ListNode p = new ListNode(val%10);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            val = stack1.pop().val + stack2.pop().val + jinWei;
            jinWei = val/10;
            ListNode tmp = new ListNode(val%10);
            tmp.next = p;
            p = tmp;
        }
        while (!stack1.isEmpty()) {
            val = stack1.pop().val + jinWei;
            jinWei = val/10;
            ListNode tmp = new ListNode(val%10);
            tmp.next = p;
            p = tmp;
        }
        while (!stack2.isEmpty()) {
            val = stack2.pop().val + jinWei;
            jinWei = val/10;
            ListNode tmp = new ListNode(val%10);
            tmp.next = p;
            p = tmp;
        }
        if (jinWei != 0) {
            ListNode tmp = new ListNode(jinWei);
            tmp.next = p;
            p = tmp;
        }
        return p;
    }

    private static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null?l2:l1;
        }
        Deque<ListNode> queue = new LinkedList<>();
        int len1=0, len2=0, len=0;
        ListNode cur = l1;
        while (cur != null) {
            len1++;
            cur = cur.next;
        }
        cur = l2;
        while (cur != null) {
            len2++;
            cur = cur.next;
        }
        cur = len1 > len2?l1:l2;
        ListNode mcur = len1 > len2?l2:l1;
        len = Math.abs(len1-len2);
        while (len > 0) {
            queue.addLast(cur);
            len--;
            cur = cur.next;
        }
        while (cur != null) {
            queue.addLast(new ListNode(cur.val + mcur.val));
            cur = cur.next;
            mcur = mcur.next;
        }
        len = len1 >= len2?len1:len2;
        int c = 0;
        while (len-- != 0) {
            cur = queue.pollLast();
            int value = cur.val + c;
            cur.val = value %10;
            queue.addFirst(cur);
            c = value/10;
        }
        if (c == 1) {
            queue.addFirst(new ListNode(1));
        }
        ListNode head = queue.peekFirst();
        while (!queue.isEmpty()) {
            queue.pollFirst().next = queue.peekFirst();
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers2(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

}
