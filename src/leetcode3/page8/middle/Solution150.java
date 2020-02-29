package leetcode3.page8.middle;

import java.util.Stack;

public class Solution150 {

    private static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length < 1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for(String str: tokens){
            if ("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str) ) {
                int tmp2 = stack.pop();
                int tmp1 = stack.pop();
                switch(str) {
                    case "+": tmp1 = tmp1+tmp2;break;
                    case "-": tmp1 = tmp1-tmp2;break;
                    case "*": tmp1 = tmp1*tmp2;break;
                    case "/": tmp1 = tmp1/tmp2;
                }
                stack.push(tmp1);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] strs = {"10", "6"};
        int i = evalRPN(strs);
        System.out.println(i);
    }
}
