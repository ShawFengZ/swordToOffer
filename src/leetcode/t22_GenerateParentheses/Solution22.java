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
    public static List<String> generateParenthesis(int n){
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
    }
}
