package t14_findKthToTail;

/**
 * @author zxf
 * @date 2018/8/11 19:28
 */
public class Solution14 {
    public ListNode FindKthToTail(ListNode head,int k) {
        //搞两个指针，同时向后移动，让二者相差为k，一个到尾部的时候另一个就刚好到倒数第k的位置
        ListNode p, q;
        p = q =head;
        int i=0;
        for (; p!=null; i++){
            if (i >= k){//p是较后的指针
                q = q.next;
            }
            p = p.next;
        }
        //如果k的大小比这个链表还长，直接返回null
        return i < k ? null: q;
    }
}
