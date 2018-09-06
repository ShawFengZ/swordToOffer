package book.t23_meetingNode;

/**
 * @author zxf
 * @date 2018/9/6 14:30
 */
public class SolutionBook23 {
    /**
     * 题目：如果一个链表包含环，如何找出环的入口节点
     * 思路：
     *      1. 确定是否有环
     *         两个指针，一个一次走1步，一个一次走2步，如果相遇，则说明有环
     *      2. 确定环中的节点的数目
     *         两个指针相遇一定是在环中，此时用慢的那个走，走一步记一次数，计算得到n
     *      3. 找环的入口
     *          两个指针，一个先走n步，另一个起步，当他们相遇的时候，正好到入口处
     * */
    private int getRingNumber(t23ListNode head){
        if (head == null)
            return -1;
        boolean hasRing = false;
        t23ListNode fast = head;
        t23ListNode slow = head;
        while (fast != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                hasRing = true;
                break;
            }
        }
        int count = -1;
        if (hasRing){
            count = 1;
            slow = slow.next;
            while (fast != slow){
                slow = slow.next;
                count++;
            }
        }
        return count;
    }

    public t23ListNode entryNodeOfLoop(t23ListNode head){
        //确定是否有环，及环中的节点数
        int count = getRingNumber(head);
        if (count == -1)
            return null;
        //定义两个指针
        t23ListNode first = head;
        for (int i=0; i<count; i++){
            first = first.next;
        }
        t23ListNode last = head;
        for (int i = 0; i< count ; i++){
            first = first.next;
            last = last.next;
            if (first == last){
                break;
            }
        }
        return first;
    }
}
