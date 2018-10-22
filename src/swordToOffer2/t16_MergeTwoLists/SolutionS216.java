package swordToOffer2.t16_MergeTwoLists;

/**
 * @author zxf
 * @date 2018/10/22 14:47
 */
public class SolutionS216 {
    /**
     * 题目描述：
     *      合并两个升序链表。
     * 思路：
     *      没什特别的思路，直接合并即可。
     * */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode head = null;
        ListNode p = null;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val) {
                if (head == null) {
                    head = p = list1;
                    p = p.next;
                } else {
                    p = list1;
                    p = p.next;
                }
                list1 = list1.next;
            } else {
                if (head == null) {
                    head = p = list2;
                    p = p.next;
                } else {
                    p = list2;
                    p = p.next;
                }
                list2 = list2.next;
            }
        }
        if (list1 != null)
            p.next = list1;
        if (list2 != null)
            p.next = list2;
        return head;
    }
}
