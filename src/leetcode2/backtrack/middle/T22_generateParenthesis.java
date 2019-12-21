package leetcode2.backtrack.middle;

import java.util.ArrayList;
import java.util.List;

public class T22_generateParenthesis {
    /**
     * 括号生成
     *
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * */
    private static List<String> generateParenthesis(int n) {
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
            //String ans1 = new String(ans);
            generate(res, ans+"(", cnt1+1, cnt2, n);
            generate(res, ans+")", cnt1, cnt2+1, n);
        }
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
    }
}
