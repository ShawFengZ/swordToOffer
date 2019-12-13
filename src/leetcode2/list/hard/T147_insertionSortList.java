package leetcode2.list.hard;

import leetcode2.utils.ListNode;

import javax.swing.*;

public class T147_insertionSortList {
    /**
     * 对链表进行插入排序
     *
     * 方法一：自己做的，不够快
     * 方法二：别人做的，思路简单，而且执行很快，减少了比较次数
     *      想要排序块，就要尽可能少的做比较
     *      需要一个指针指向当前已排序的最后一个位置，这里用的是head指针
     *      需要另外一个指针pre,每次从表头循环，这里用的是dummy表头指针。
     *      每次拿出未排序的节点，先和前驱比较，如果大于或者等于前驱，就不用排序了，直接进入下一次循环
     *      如果前驱小，则进入内层循环，依次和pre指针比较，插入对应位置即可。
     * */
    private static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        ListNode p = pre;
        pre.next = head;
        while (p.next != null) {
            ListNode tmp = pre;
            while (tmp.next!= null && tmp.next.val < p.next.val) {
                tmp = tmp.next;
            }
            if (tmp != p) {
                ListNode target = p.next;
                p.next = target.next;
                target.next = tmp.next;
                tmp.next = target;
            } else {
                p = p.next;
            }
        }
        return pre.next;
    }

    private static ListNode insertionSortList2(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0), pre;
        dummy.next = head;
        while (head != null && head.next != null) {
            if (head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            pre = dummy;
            while (pre.next.val < head.next.val) {
                pre = pre.next;
            }
            ListNode cur = head.next;
            head.next = head.next.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(5);

        ListNode listNode = insertionSortList2(head);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
