package leetcodeDifficult.t24_SwapNodesInPairs;

/**
 * @author zxf
 * @date 2018/10/19 14:31
 */
public class SolutionD24 {
    /**
     * 题目描述：
     *      给一个链表，每相邻的两个节点交换位置，然后返回。
     * 思路：本质上还是一个交换节点的问题。
     *      1. 交换两个节点需要三个指针
     *          这三个指针跨越了4个节点
     * 测试：
     *      0. 空节点的情况；
     *      1. 只有一个节点的情况；
     *      2. 只有两个节点的情况；
     *      3. 只有三个节点的情况；
     * */
    public static ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(0);
        ListNode pre = preHead,post;
        pre.next = head;
        while (head!=null&&head.next!=null) {
            post = head.next.next;
            //节点交换
            pre.next = head.next;
            pre.next.next = head;
            //调整交换后的第二个节点的next节点
            head.next = post;
            pre = head;
            head = head.next;
        }
        return preHead.next;
    }

    //测试
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        /*head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);*/
        head = swapPairs(head);
        ListNode p = head;
        while (p!=null){
            System.out.print(p.val+" ");
            p = p.next;
        }
    }
}
