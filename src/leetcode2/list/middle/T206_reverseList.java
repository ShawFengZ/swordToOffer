package leetcode2.list.middle;

import leetcode2.utils.ListNode;
import sun.management.snmp.util.SnmpTableCache;

import java.util.Stack;

public class T206_reverseList {
    /**
     * 反转链表：
     *
     * 三种做法：
     * 1. 使用栈
     * 2. 递归
     * 3. 指针法
     * */
    private static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode p = head;
        while (!stack.isEmpty()) {
            stack.pop();
            p = p.next;
            p.next = null;
        }
        return head;
    }

    //递归的方法
    private static ListNode reverseList2(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head.next;
        head.next = null;
        ListNode newHead = reverseList2(p);
        ListNode q = newHead;
        while (q.next != null) {
            q = q.next;
        }
        q.next = head;
        return newHead;
    }

    /**
     * 指针法
     * */
    private static ListNode reverseList3(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = null;
        ListNode q = head;
        ListNode r = head.next;
        while (true) {
            q.next = p;
            p = q;
            q = r;
            if (r != null) {
                r = r.next;
            } else {
                break;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(6);
        ListNode listNode = reverseList3(head);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
