package leetcode2.stack.middle;

import java.nio.file.Paths;
import java.util.Stack;

public class T71_simplifyPath {
    /**
     * 简化路径
     *
     * 方法一：搞笑版(这个版本是最初的提交版，但是作为技术人员，切忌不可就这样了)
     * 方法二：使用栈
     * */
    private static String simplifyPath(String path) {
        return Paths.get(path).normalize().toString();
    }

    /**
     * 定义一个辅助栈
     * */
    private static String simplifyPath2(String path){
        if (path == null || path.length() == 0) {
            return path;
        }
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");
        for (int i=0; i<split.length; i++) {
            if (split[i].equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!(split[i].equals(".") || split[i].equals("")
                    || split[i].equals(".."))) {
                stack.push(split[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<stack.size(); i++) {
            sb.append("/" + stack.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "/home//foo/";
        String path2 = simplifyPath2(str);
        System.out.println(path2);
    }
}
