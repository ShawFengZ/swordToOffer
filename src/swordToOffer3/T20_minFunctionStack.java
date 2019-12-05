package swordToOffer3;

import java.util.Stack;

public class T20_minFunctionStack {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    public void push(int node) {
        stack1.push(node);
        if (stack2.size() > 0 && stack2.peek() < node) {
            stack2.push(stack2.peek());
        } else {
            stack2.push(node);
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
