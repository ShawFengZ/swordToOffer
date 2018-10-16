package leetcode.t20_ValidParentheses;

import java.util.Stack;

/**
 * @author zxf
 * @date 2018/10/16 14:26
 */
public class solution20 {

    /**
     * 题目描述：
     *      判断括号是否有效
     * 思路：
     *      1. 用一个栈，依次压入括号符号
     *      2. 判断如果是左括号，直接压入，如果是有括号则判断是否能匹配
     *      3. 能匹配则弹出，不能匹配直接报错
     * */
    public static boolean isValid(String s) {
        if (s==null || s.length()%2==1)
            return false;
        if ("".equals(s))
            return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || isLeftOrRight(s.charAt(i)))
                stack.push(s.charAt(i));
            if (!stack.isEmpty() && !isLeftOrRight(s.charAt(i)) && isMatch(stack.peek(), s.charAt(i))){
                stack.pop();
                continue;
            }
            if (!stack.isEmpty() && !isLeftOrRight(s.charAt(i)) && !isMatch(stack.peek(), s.charAt(i))){
                break;
            }
        }
        return stack.isEmpty();
    }

    //判断是否是左括号
    private static boolean isLeftOrRight(Character ch){
        if (ch.equals('(') || ch.equals('{') || ch.equals('['))
            return true;
        if (ch.equals(')') || ch.equals('}') || ch.equals(']'))
            return false;
        else return false;
    }

    //判断是否匹配
    private static boolean isMatch(Character ch1, Character ch2) {
        if ((ch1.equals('(') && ch2.equals(')')) || (ch1.equals('[') && ch2.equals(']'))
                || (ch1.equals('{') && ch2.equals('}')))
            return true;
        else
            return false;
    }
}
