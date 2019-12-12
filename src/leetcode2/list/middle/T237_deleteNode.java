package leetcode2.list.middle;

import leetcode2.utils.ListNode;

public class T237_deleteNode {
    /**
     * 删除指定的节点
     *
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     *
     * 输入: head = [4,5,1,9], node = 5
     * 输出: [4,1,9]
     *
     * 往前移动数据，删除最后一个节点
     * */
    public void deleteNode(ListNode node) {
        if(node == null) {
            return;
        }
        while(node.next != null) {
            node.val = node.next.val;
            if(node.next.next == null) {
                node.next = null;
                return;
            }
            node = node.next;
        }
    }
}
