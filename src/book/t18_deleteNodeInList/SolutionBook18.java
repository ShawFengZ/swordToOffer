package book.t18_deleteNodeInList;

/**
 * @author zxf
 * @date 2018/9/5 14:51
 */
public class SolutionBook18 {
    /**
     * 题目一描述：
     *      在O(1)的时间内删除链表节点
     *      给定单项链表的头指针和一个节点指针，定义一个函数在O(1)的时间复杂度内删除节点；
     * 分析：
     *      1. 从头节点遍历找到该节点的前一个节点和该节点，修改前一个节点的指针指向该节点的后一个节点
     *          时间复杂度O(n)，不符合要求
     *      2. 直接将p的后一个节点的内容复制到p节点，同时删除其后一个节点
     *          时间复杂度O(1)
     *          两种特殊情况：1. 只有一个节点的情况，删除节点后还要把头指针设为空
     *                        2. 删除的是尾节点，这种还是要从头遍历到尾
     *          复杂度分析：
     *              1. n-1个非尾节点，时间复杂度是O(1)
     *              2. 1个尾节点，时间复杂度是O(n)
     *              3. 平均时间复杂度((n-1)*O(1) + O(n))/n
     *      对于以上解法，有一个假设，就是要删除的节点是在链表中的，因此这个要求必须deleteNode的调用者满足
     *      与面试官要交流这一点，让他们看到思路的严谨性
     * */
    public void deleteNode(t18ListNode head, t18ListNode p){
        if (head == p && p.next == null) {//链表只有一个节点
            head = null;
            return;
        }
        if (p.next == null) {//删除的是尾节点
            t18ListNode pre = head;
            //pre为p的前一个节点
            while (pre.next != p){
                pre = pre.next;
            }
            //修改指针
            pre.next = null;
            return;
        }
        p.value = p.next.value;
        p.next = p.next.next;
    }

    /**
     * 题目二描述
     *      删除链表中重复的节点
     *      在一个排序链表中，如何删除重复的节点？
     * 思路：
     *      两个指针，分别往后遍历pre, q
     *      pre是q的前一个指针，如果q.val = q.next.val, 就q指向下一个节点，pre.next=q, pre不变。
     *      另外不要遗漏头节点
     * */
    public void deleteDuplicateNode(t18ListNode head){
        //判断头节点是否为空
        if (head == null)
            return;
        //判断头节点是不是重复的
        if (head.value == head.next.value){
            head = head.next;
        }
        t18ListNode pre = head;
        t18ListNode q = head.next;
        while (q.next!=null){
            if (q.next.value == q.value){//如果是重复的
                q = q.next;
                pre.next = q;
            }else { //不是重复的
                pre = q;
                q = q.next;
            }
        }
    }
}
