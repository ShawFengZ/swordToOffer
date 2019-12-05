package swordToOffer3;

import java.util.Stack;

public class T21_isPopOrder {
    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，
     * 请判断第二个序列是否可能为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。
     * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
     * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
     *
     * 思路：
     * 1. 有一个index在pop2上移动，比如
     * */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        int index2 = 0, index1 = 0;
        Stack<Integer> stack = new Stack<>();
        while (index1<pushA.length && index2 < popA.length) {
            while (pushA[index1] != popA[index2]) {
                stack.push(pushA[index1++]);
            }
            index1++;
            index2++;
        }
        if (stack.size() != 0) {
            while (index2 < popA.length) {
                if (popA[index2++] != stack.pop()) {
                    return false;
                }
            }
        }
        return index2==popA.length&&stack.size()==0;
    }
}
