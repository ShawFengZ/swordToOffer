package book.t9_2StackToQueue;

import java.util.Stack;

/**
 * @author zxf
 * @date 2018/8/30 13:17
 */
public class SolutionBook9 {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        //需要压栈就全部放到stack1中
        stack1.push(node);
    }

    public int pop(){
        //先判断stack2是否为空,不为空就直接出
        if (stack2.size()>0){
            return stack2.pop();
        }else {//为空就将stack1中的内容全部放到stack2中再出栈
            //出栈先将stack1中的内容全部出栈并放到stack2中，再从stack2中出栈
            while (stack1.size()>0){
                int node = stack1.pop();
                stack2.push(node);
            }
            if (stack2.size()>0)
                return stack2.pop();
            else
                return -1;
        }
    }
}
