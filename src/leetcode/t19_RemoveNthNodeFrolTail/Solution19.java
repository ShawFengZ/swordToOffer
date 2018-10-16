package leetcode.t19_RemoveNthNodeFrolTail;

import java.util.List;

/**
 * @author zxf
 * @date 2018/10/16 13:46
 */
public class Solution19 {
    /**
     * 题目描述：
     *      给定一个链表，和一个n删除倒数第n个节点(n始终有效)
     * 思路：
     *      1. 两个指针，first(先)，last(后)
     *      2. first走了n步，last开始走，
     *      3. first走到尾部，last指向的节点删除
     *      4. 删除该节点
     * */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next==null)
            return null;
        ListNode first = head;
        ListNode last = head;
        while (n > 0) {
            first = first.next;
            n--;
        }
        while (first != null) {
            first = first.next;
            last = last.next;
        }
        //System.out.println(last.val);
        //删除last指向的节点
        head = deleteNode(head, last);
        return head;
    }

    //删除节点
    private static ListNode deleteNode(ListNode head, ListNode p){
        if (head == p){//删除头节点
            head = head.next;
            return head;
        }
        ListNode pre = head;
        while (pre.next != p)
            pre = pre.next;
        //删除操作
        pre.next = pre.next.next;
        return head;
    }
}
