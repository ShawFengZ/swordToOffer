package leetcode2.stack.easy;

import java.util.Stack;

public class T20_isValid {
    /**
     * 有效的括号
     *
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * */
    public static boolean isValid(String s) {
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
                case '(':
                case '{':
                case '[': {
                    stack.push(chars[i]);
                    continue;
                }
                case ')':
                case '}':
                case ']': {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop = stack.pop();
                    char tmp = chars[i];
                    if (!((pop=='('&&tmp==')')||(pop=='{'&&tmp=='}')
                            ||(pop=='['&&tmp==']'))) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
