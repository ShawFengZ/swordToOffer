package swordToOffer2.t05_2StackToQueue;

import java.util.Stack;

/**
 * @author zxf
 * @date 2018/10/22 9:02
 */
public class SolutionS205 {
    /**
     * 题目描述：
     *      用两个栈实现队列的push和pop操作
     * 思路：
     *      1. push：直接push进stack1
     *      2. pop: 检查stack2中是否有内容，如果有直接pop
     *              如果没有，将stack1中的内容依次弹出压入stack2中，再弹出stack2
     *              如果stack1也是空，报错
     * */
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        stack1.push(node);
    }

    //出栈操作
    public int pop(){
        if (!stack2.isEmpty())
            return stack2.pop();
        else {
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            } else
                return -1;
        }
    }
}
