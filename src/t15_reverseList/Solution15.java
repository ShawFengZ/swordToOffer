package t15_reverseList;


import java.util.List;

/**
 * @author zxf
 * @date 2018/8/11 21:27
 */
public class Solution15 {
    //注意反转单链表的思路啊
    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = null;
        ListNode next = null;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
