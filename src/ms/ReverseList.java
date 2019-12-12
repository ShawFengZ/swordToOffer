package ms;

import java.util.HashMap;
import java.util.Stack;

public class ReverseList {

    public static ListNode reverseList(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = null;
        ListNode q = head;
        ListNode r = head.next;
        while (q.next != null) {
            q.next = p;
            p = q;
            q = r;
            if (r != null) {
                r = r.next;
            } else {
                break;
            }
        }
        return q;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()) {
            return null;
        }
        ListNode newHead = stack.pop();
        ListNode res = newHead;
        while (!stack.isEmpty()) {
            res.next = stack.pop();
            res = res.next;
            res.next = null;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode listNode = reverseList2(head);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
