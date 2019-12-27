package leetcode3.page1.easy;

import java.util.Stack;

public class T20_isValid {
    /**
     * 判断括号是否有效
     *
     * 使用栈
     * */
    private static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2==1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; i++) {
            switch (chars[i]) {
                case '[':
                case '{':
                case '(': {
                    stack.push(chars[i]);
                    continue;
                }
                case ']':
                case '}':
                case ')': {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop = stack.pop();
                    if (!((pop=='('&&chars[i]==')')||(pop=='['&&chars[i]==']')
                            ||(pop=='{'&&chars[i]=='}'))) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([)]";
        boolean valid = isValid(s);
        System.out.println(valid);
    }
}