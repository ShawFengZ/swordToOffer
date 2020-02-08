package leetcode3.page4.middle;

import java.util.Stack;

public class T71_simplifyPath {

    /**
     * 简化路径
     * */
    private static String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str: split) {
            if ("..".equals(str)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            } else if (".".equals(str) || "".equals(str)) {
                continue;
            }
            stack.push(str);
        }
        String res = "";
        while(!stack.isEmpty()) {
            res = stack.pop() + "/" + res;
        }
        if (res.length() > 0) {
            res = res.substring(0, res.length()-1);
        }
        res = "/" + res;
        return res;
    }

    public static void main(String[] args) {
        String path = "/../";
        String path1 = simplifyPath(path);
        System.out.println(path1);
    }
}
