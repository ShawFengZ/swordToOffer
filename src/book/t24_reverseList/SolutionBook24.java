package book.t24_reverseList;

/**
 * @author zxf
 * @date 2018/9/6 16:49
 */
public class SolutionBook24 {
    /**
     *  题目描述：
     *      定义一个函数，输入一个链表的头节点，反转该链表并输出反转后的链表的头节点。
     *  思路：
     *      1. 反转链表需要三个指针，p(前)，q(操作)，r(后)
     *      2. 注意鲁棒性
     *          1) head为空
     *          2) 长度为1
     *          3) 长度为2
     * */
    public t24ListNode reverseList(t24ListNode head){
        if (head == null || head.next == null)
            return null;
        if (head.next.next == null){
            t24ListNode tail = head.next;
            head.next = null;
            tail.next = head;
            return tail;
        }
        t24ListNode p = head;
        t24ListNode q = head.next;
        t24ListNode r = head.next.next;
        while (r != null){
            q.next = p;
            p = q;
            q = r;
            r = r.next;
        }
        //最后两个节点
        q.next = p;
        return q;
    }
}
