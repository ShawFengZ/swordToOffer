package leetcode.t2_addTwoNumbers;

import t16_mergeList.ListNode;

import java.util.Stack;

/**
 * @author zxf
 * @date 2018/9/25 20:23
 */
public class Solution2 {
    /**
     * 题目描述：
     *      输入两个链表(2, 4, 3), (5, 6, 4)
     *      输出(7, 0, 8)
     *      因为342+465=708
     * 思路：
     *      1. 将这两个数用栈保存起来
     *      2. 取出栈顶的元素相加
     *      3. 将剩下的没取完的元素加在后面
     * 以下完全错误-_-! 没有考虑加法到底是什么啊大哥
     * */
    public static ListNode02 addTwoNumbers(ListNode02 l1, ListNode02 l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
        }
        int jinwei = 0;
        int sum = 0;
        if (!stack1.isEmpty() && !stack2.isEmpty()){
            sum = stack1.pop() + stack2.pop();
            jinwei = sum/10;
            sum = sum%10;
        }
        ListNode02 l3 = new ListNode02(sum);
        ListNode02 head = l3;

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            sum = stack1.pop() + stack2.pop() + jinwei;
            jinwei = sum/10;
            sum = sum%10;
            l3.next = new ListNode02(sum);
            l3 = l3.next;
        }
        if (!stack1.isEmpty()) {
            sum = stack1.pop() + jinwei;
            jinwei = sum/10;
            sum = sum%10;
            l3.next = new ListNode02(sum);
            l3 = l3.next;
        }
        if (!stack2.isEmpty()) {
            sum = stack2.pop() + jinwei;
            jinwei = sum/10;
            sum = sum%10;
            l3.next = new ListNode02(sum);
            l3 = l3.next;
        }
        if (jinwei != 0) {
            l3.next = new ListNode02(jinwei);
        }
        return head;
    }

    public static ListNode02 addTwoNumbers2(ListNode02 l1, ListNode02 l2){
        int sum = 0;
        int jinwei = 0;
        if (l1 != null && l2 != null) {
            sum = l1.val + l2.val;
            jinwei = sum/10;
            sum = sum%10;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode02 l3 = new ListNode02(sum);
        ListNode02 head = l3;
        while (l1 != null && l2!= null) {
            sum = l1.val + l2.val + jinwei;
            jinwei = sum/10;
            sum = sum%10;
            l1 = l1.next;
            l2 = l2.next;
            l3.next = new ListNode02(sum);
            l3 = l3.next;
        }
        while (l1 != null) {
            sum = l1.val + jinwei;
            jinwei = sum/10;
            sum = sum%10;
            l1 = l1.next;
            l3.next = new ListNode02(sum);
            l3 = l3.next;
        }
        while (l2 != null) {
            sum = l2.val + jinwei;
            jinwei = sum/10;
            sum = sum%10;
            l2 = l2.next;
            l3.next = new ListNode02(sum);
            l3 = l3.next;
        }
        if (jinwei != 0) {
            l3.next = new ListNode02(jinwei);
        }
        return head;
    }
}
