package leetcode2.list.middle;

import leetcode2.utils.ListNode;

public class T328_oddEvenList {
    /**
     * 奇偶链表
     *
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
     * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     *
     * 思路(写错了，注意审题)：
     * 1. p的下一个节点是偶数，q自身是偶数，q的下一个节点是奇数
     * 2. 更改指针
     *
     * 思路二：
     * 1. 直接更新p, q即可
     * */
    private static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHeadPre = new ListNode(0);
        newHeadPre.next = head;
        ListNode p = newHeadPre, q = head;
        while (p.next != null && q.next != null) {
            if (p.next.val % 2 != 0) {
                p = p.next;
            }
            if (!(q.val%2==0 && q.next.val%2==1)) {
                q = q.next;
            }
            ListNode tmp =q.next;
            q.next = q.next.next;
            tmp.next = p.next;
            p.next = tmp;
        }
        return newHeadPre.next;
    }

    private static ListNode oddEvenList2(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head2 = head.next;
        ListNode p = head, q = head2;
        while (p.next != null || q.next != null) {
            if (p.next != null) {
                p.next = p.next.next;
                if (p.next != null) {
                    p = p.next;
                }
            }
            if (q.next != null) {
                q.next = q.next.next;
                if (q.next != null) {
                    q = q.next;
                }
            }
        }
        p.next = head2;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next= new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode listNode = oddEvenList2(head);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
