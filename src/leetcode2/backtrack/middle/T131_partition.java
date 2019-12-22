package leetcode2.backtrack.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T131_partition {
    /**
     * 分割回文串
     *
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
     * 返回 s 所有可能的分割方案。
     * */
    private static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null|| s.length() == 0) {
            return res;
        }
        Stack<String> stack = new Stack<>();
        partition(s, 0, s.length(), stack, res);
        return res;
    }

    private static void partition(String s, int start, int len,
                                  Stack<String> path, List<List<String>> res){
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=start; i<len; i++) {
            //如果不是回文直接跳过
            if (!isPalindrome(s, start, i)) {
                continue;
            }
            path.add(s.substring(start, i+1));
            partition(s, i+1, len, path, res);
            path.pop();
        }
    }

    private static boolean isPalindrome(String str, int left, int right){
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> partition = partition(s);
        System.out.println(partition);
    }
}
