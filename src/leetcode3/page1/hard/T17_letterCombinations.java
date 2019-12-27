package leetcode3.page1.hard;

import java.util.ArrayList;
import java.util.List;

public class T17_letterCombinations {
    /**
     * 递归
     * */
    private static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        String[] stringTable = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        letterCombinations(list, digits, "", 0, stringTable);
        return list;
    }

    private static void letterCombinations(List<String> res, String digits, String cur,
                                           Integer index, String[] table){
        if (index == digits.length() && cur.length() != 0) {
            res.add(cur);
            return;
        }
        String tmp = table[digits.charAt(index)-'0'];
        for (int i=0; i<tmp.length(); i++) {
            cur += tmp.charAt(i);
            letterCombinations(res, digits, cur, index+1, table);
            cur = cur.substring(0, cur.length()-1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> list = letterCombinations(digits);
        System.out.println(list);
    }
}
