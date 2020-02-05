package leetcode.t22_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zxf
 * @date 2018/10/16 15:13
 */
public class Solution22 {

    /**
     * 题目描述：
     *      输入一个数字n，表示有n对括号，输出n对括号所有的可能
     * 思路：
     *      1.
     * */
    /*public static List<String> generateParenthesis(int n){
        List<String> res = new ArrayList<>();
        helper(n, n, "", res);
        return res;
    }

    private static void helper(int left, int right, String out, List<String> res){
        if ( left < 0 || right < 0 || left > right)
            return;
        //边界条件
        if (left==0 && right==0)
            res.add(out);
        helper(left-1, right, out+"(", res);
        helper(left, right-1, out+")", res);
    }*/

    /*public static List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        generate(res, "", 0, 0, n);
        return res;
    }

    private static void generate(List<String> res, String ans, int cnt1, int cnt2, int n){
        if (cnt1 > n || cnt2 > n) {
            return;
        }
        if (cnt1 == n  && cnt2 == n) {
            res.add(ans);
        }
        if (cnt1 >= cnt2) {
            generate(res, ans+"(", cnt1+1, cnt2, n);
            generate(res, ans+")", cnt1, cnt2+1, n);
        }
    }*/

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0) {
            return res;
        }
        generate(res, "", 0, 0, n);
        return res;
    }

    private static void generate(List<String> res, String tmp, int cnt1, int cnt2, int n){
        if(cnt1 > n || cnt2 > n) {
            return;
        }
        if(cnt1 == n && cnt2 == n) {
            res.add(tmp);
        }
        if(cnt1 >= cnt2) {
            generate(res, tmp+"(", cnt1+1, cnt2, n);
            generate(res, tmp+")", cnt1, cnt2+1, n);
        }
    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        System.out.println(list);
    }
}
