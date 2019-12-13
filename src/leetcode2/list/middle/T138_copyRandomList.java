package leetcode2.list.middle;

import leetcode2.list.utils.Node;
import leetcode2.utils.ListNode;

public class T138_copyRandomList {

    /**
     * 复制带随机指针的链表
     *
     * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
     * */
    private static Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node p = head;
        while (p != null) {
            Node copy = new Node(p.val, p.next, null);
            p.next = copy;
            p = copy.next;
        }
        p = head;
        while (p != null && p.next != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        //分离两个链表节点
        p = head;
        Node cloneHead = p.next;
        while (p != null && p.next != null) {
            Node cloneNode = p.next;
            p.next = cloneNode.next;
            if (cloneNode.next != null) {
                cloneNode.next = cloneNode.next.next;
            }
            p = p.next;
        }
        return cloneHead;
    }

    public static void main(String[] args) {
        Node head = new Node(1, null, null);
        head.next = new Node(2, null, null);
        head.next.next = new Node(3, null, null);
        head.next.random = head.next.next;

        Node node = copyRandomList(head);
        System.out.print(node.val + " ");
        System.out.print(node.next.val + " ");
        System.out.print(node.next.next.val + " ");
        System.out.print(node.next.random.val + " ");
    }
}
