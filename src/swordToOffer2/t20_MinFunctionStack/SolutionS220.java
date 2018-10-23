package swordToOffer2.t20_MinFunctionStack;

import java.util.Stack;

/**
 * @author zxf
 * @date 2018/10/23 9:37
 */
public class SolutionS220 {
    /**
     * 包含min函数的栈，实现一个栈，包含能得到最小元素的栈，时间复杂度为O(1).
     * 思路：
     *      1. 两个栈，stack1存放正常元素，实现普通功能。
     *      2. stack1中压入3时， stack2中压入3；stack1中压入4时，stack2中还是压入3；stack1中压入2时，stack2压入2
     * */
    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public static void push(int node) {
        stack1.push(node);
        if (stack2.isEmpty())
            stack2.push(node);
        else {
            if (node < stack2.peek())
                stack2.push(node);
            else
                stack2.push(stack2.peek());
        }
    }

    public static void pop() {
        if (!stack2.isEmpty() && !stack1.isEmpty()) {
            stack2.pop();
            stack1.pop();
        }
    }

    public static int top() {
        if (!stack1.isEmpty())
            return stack1.pop();
        else
            return -1;
    }

    public static int min() {
        if (!stack2.isEmpty())
            return stack2.peek();
        else
            return -1;
    }

    public static void main(String[] args) {
        push(3);
        System.out.print(min() + " ");
        push(4);
        System.out.print(min() + " ");
        push(2);
        System.out.print(min() + " ");
        push(3);
        System.out.print(min() + " ");
        pop();
        System.out.print(min() + " ");
        pop();
        System.out.print(min() + " ");
        pop();
        System.out.print(min() + " ");
        push(0);
        System.out.print(min() + " ");
    }
}
