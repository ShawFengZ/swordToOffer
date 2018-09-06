package book.t22_findKthToTail;

/**
 * @author zxf
 * @date 2018/9/6 14:07
 */
public class SolutionBoot22 {
    /**
     * 22. 题目描述
     *      输入一个链表，输出该链表的倒数第k个节点。本题从1计数
     * 思路：
     *      1. 两个指针，pre和p
     *      2. p指向第k个节点的时候，pre指向头节点
     *      3. 同时后移，当p指向尾节点的时候，pre刚好指向头节点
     * */
    public t22ListNode findKthToTail(t22ListNode head, int k){
        t22ListNode p=head;
        //判断，如果k大于链表的长度，返回null
        for (int i=0; i<k; i++){
            if (p.next != null){
                p = p.next;
            } else { //说明k的大于链表的长度
                return null;
            }
        }
        t22ListNode pre = head;
        while (p.next!=null){//同时后移，当p到尾节点的时候停止
            p = p.next;
            pre = pre.next;
        }
        return pre;
    }
}
