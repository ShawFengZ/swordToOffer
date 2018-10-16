package leetcode.t24_SwapNodesInPairs;

import java.util.List;

/**
 * @author zxf
 * @date 2018/10/16 15:48
 */
public class Solution24 {
    /**
     * 给定一个链表，交换相邻的两个数字，空见复杂度为O(1),只能交换node本身
     * 思路：
     *      1. 交换
     *      2. 往后移动两位
     * */
    public static ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(-1);
        root.next = head.next;
        ListNode rootH = root;
        ListNode pre = head;
        ListNode p = head.next;
        while (p!=null && pre != null) {
            rootH.next = p;
            pre.next = p.next;
            p.next = pre;
            pre = pre.next;
            if (pre != null)
                p = pre.next;
            rootH = p.next;
        }
        return root.next;
    }

    //测试交换节点
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode listNode = swapPairs(head);
        while (listNode!=null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
