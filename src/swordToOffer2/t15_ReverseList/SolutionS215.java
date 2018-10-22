package swordToOffer2.t15_ReverseList;

/**
 * @author zxf
 * @date 2018/10/22 14:35
 */
public class SolutionS215 {
    /**
     * 题目描述：反转链表
     * 思路：
     *      1. 两个指针即可完成指针的反转
     * */
    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = null;
        ListNode next = null;
        while (head!=null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


}
