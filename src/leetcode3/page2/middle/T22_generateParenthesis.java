package leetcode3.page2.middle;

import java.util.ArrayList;
import java.util.List;

public class T22_generateParenthesis {
    /**
     * 括号生成
     *
     * 使用回溯法
     * */
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        String ans = "";
        generateParenthesis(res, 0, 0, n, ans);
        return res;
    }

    private static void generateParenthesis(List<String> res, int cnt1, int cnt2, int n, String ans){
        if (cnt1 > n || cnt2 > n) {
            return;
        }
        if (cnt1==n && cnt2==n) {
            res.add(ans);
        }
        if (cnt1 >= cnt2) {
            generateParenthesis(res,cnt1+1, cnt2, n, ans+"(");
            generateParenthesis(res, cnt1, cnt2+1, n, ans+")");
        }
    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        System.out.println(list);
    }
}
