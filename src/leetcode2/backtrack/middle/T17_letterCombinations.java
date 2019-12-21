package leetcode2.backtrack.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T17_letterCombinations {
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * */
    private static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        helper("", digits, 0, res, map);
        return res;
    }

    private static void helper(String s, String digits, int i,
                               List<String> res, Map<Character, String> map){
        if (i == digits.length()) {
            res.add(s);
            return;
        }
        String letters = map.get(digits.charAt(i));
        for (int j=0; j<letters.length(); j++) {
            helper(s+letters.charAt(j), digits, i+1, res, map);
        }
    }
}
