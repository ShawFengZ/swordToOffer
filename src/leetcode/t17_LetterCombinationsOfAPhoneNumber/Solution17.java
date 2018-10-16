package leetcode.t17_LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zxf
 * @date 2018/10/16 10:31
 */
public class Solution17 {
    /**
     * 题目描述：
     *      1. 给一个数字字符串
     *      2. 从中选出字母的可能的组合
     * 思路：
     *      回溯法
     * */
    public static List<String> letterCombinations(String digits) {
        /*if (digits == null || "".equals(digits))
            return null;*/
        String[] stringTable = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        //index从0开始，即digits的第一个数字
        letterCombinations(list, digits, "", 0, stringTable);
        return list;
    }

    private static void letterCombinations(List<String> list, String digits,
                                    String curr, int index, String[] table) {
        //最后一层推出条件
        if (index == digits.length()) {
            if (curr.length() != 0)
                list.add(curr);
            return;
        }

        //找到数字对应的字符串
        String temp = table[digits.charAt(index) - '0'];
        for (int i = 0; i < temp.length(); i++) {
            //每次循环把不同的字符串添加到当前curr之后
            String next = curr + temp.charAt(i);
            //进入下一层
            letterCombinations(list, digits, next, index + 1, table);
        }
    }
}
