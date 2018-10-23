package swordToOffer2.t21_IsPopOrder;

import java.util.Stack;

/**
 * @author zxf
 * @date 2018/10/23 10:22
 */
public class SolutionS221 {
    /**
     * 题目描述;
     *      输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
     *      假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈
     *      序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的
     *      长度是相等的）
     * 思路：
     *      1. 将第一个序列的压入栈中，直到遇到第二个序列的第一个元素。
     *      2. 第二个序列往后移动第一个序列判断栈顶是否相等，如果是则弹出，index2++;如果否则继续压栈
     * */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (popA.length != pushA.length)
            return false;
        int length = pushA.length;
        int index1 = 0, index2 = 0;
        Stack<Integer> stack = new Stack<>();
        while (index2 < length && index1 < length) {
            if (pushA[index1] != popA[index2]) { //如果两个不等，判断栈内是否有内容
                if (!stack.isEmpty() && stack.peek() == popA[index2]) {
                    index1++;
                    index2++;
                    stack.pop();
                } else {
                    stack.push(pushA[index1]);
                    index1++;
                }
            } else {
                index1++;
                index2++;
            }
        }
        while (index2 < length) {
            if (popA[index2++] != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,3,5,1,2};
        boolean b = IsPopOrder(pushA, popA);
        System.out.println(b);
    }
}
