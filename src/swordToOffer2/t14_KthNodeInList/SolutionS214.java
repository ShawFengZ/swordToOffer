package swordToOffer2.t14_KthNodeInList;

/**
 * @author zxf
 * @date 2018/10/22 14:24
 */
public class SolutionS214 {
    /**
     * 题目描述：输入一个链表的头节点，输出倒数第k个节点。
     * 思路：
     *      1. 两个指针，pre,post.pre走到k的时候post开始走。
     *      2. pre走到尾巴的时候，post指向的就是倒数第k个节点
     * */
    public ListNode FindKthToTail(ListNode head,int k){
        ListNode pre = head, post = head;
        int count = 0;
        while (pre != null) {
            if (count >= k) {
                post = post.next;
            }
            pre = pre.next;
            count++;
        }
        if (count < k)
            return null;
        else
            return post;
    }
}
