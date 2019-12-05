package swordToOffer3;

import java.util.Stack;

public class T5_2StackToQueue {

    /**
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     *
     * 思路：
     * 1. push的时候直接进stack1
     * 2. pop的时候检查如果stack2不为空，则直接pop
     *                  如果stack2为空，则将stack1中所有的数依次pop并push进stack2中
     *                                  如果stack1也为空，则返回不能pop
     * */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else if (!stack1.isEmpty()){
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        } else {
            return -1;
        }
    }
}
