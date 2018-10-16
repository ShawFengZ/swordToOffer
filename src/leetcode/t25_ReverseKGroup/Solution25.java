package leetcode.t25_ReverseKGroup;

import java.util.Stack;

/**
 * @author zxf
 * @date 2018/10/16 16:48
 */
public class Solution25 {

    /**
     * 题目描述;
     *      给定一个链表，一个数字k，将该链表前k个节点倒序
     * 思路：
     *      1. 利用栈，一路push
     *      2. 到k之后弹出
     *      3. 每弹出一个节点，修改一个节点的next值
     * */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        for (int i=0; i<k; i++) {
            stack.push(p);
            p = p.next;
            if (p == null){
                return null;
            }
        }
        //弹出
        head = stack.pop();
        ListNode q = head;
        //head.next = q;
        while (!stack.isEmpty()) {
            q.next = stack.pop();
            q = q.next;
        }
        q.next = p;
        return head;
    }

    //测试
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode listNode = reverseKGroup(head, 2);
        while (listNode!= null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
