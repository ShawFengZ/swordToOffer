package leetcode2.list.utils;

public class Node {
    /**
     *带随机指针的链表节点
     * */
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
