package swordToOffer3;

import swordToOffer3.utils.ListNode;

public class T55_entryNodeOfLoop {

    /**
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     *
     * 1. 一个指针快fast=fast.next.next; 一个指针慢slow=slow.next;
     * 2. 当二者相遇时记录该节点，slow从头开始，slow=slow.next, fast=fast.next
     * 3. 当二者再次相遇的时候，返回该节点就是环的入口
     * */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }
        ListNode fast = pHead.next.next, slow= pHead.next;
        while (fast != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != slow) {//说明没有环
            return null;
        }
        slow = pHead;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
