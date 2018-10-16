package leetcode.t30_SubStringWithConcatenation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zxf
 * @date 2018/10/16 20:36
 */
public class Solution30 {
    /**
     * 题目描述：
     *      给一个字符串数组，其中的字符串的长度都是相同的，如果长字符串中的一个子串由字符串数组
     *      中的所有出现的单词组成，那么返回这个起点的index组成的数组
     * 思路：
     *      1. 遍历字符串s, 取出字符串，到字符串数组中比较
     *      2. 如果找到了，则进行下一步查找，没找到则继续
     *      以上解法总是出现各种问题。
     * */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (words.length <= 0 || s.length() < words[0].length())
            return list;
        int lenOfWord = words[0].length();
        int lenOfWords = words.length;
        int lenOfS = s.length();
        if (lenOfS < lenOfWord * lenOfWords)
            return list;
        for (int i=0; i<=lenOfS-lenOfWord*lenOfWords; i++) {
            List<Integer> nums = new ArrayList<>();
            if (isInArray(s, i, lenOfWord, words, nums))
                list.add(i);
        }
        return list;
    }

    /**
     * 判断words中是否有temp，nums[]代表不能选择的index
     * */
    private static boolean isInArray(String s, int index, int wordLength, String[] words, List<Integer> nums){
        if (nums.size()==words.length){
            nums.clear();
            return true;
        }
        if (index > s.length()-wordLength){
            nums.clear();
            return false;
        }
        String temp = s.substring(index, index+wordLength);
        boolean flag = false;
        for (int i=0; i<words.length; i++) {
            if (temp.equals(words[i]) && !nums.contains(i)) {
                nums.add(i);
                flag = isInArray(s, index+wordLength, wordLength, words, nums);
                if (flag)
                    break;
            } else {
                flag = false;
            }

        }
        return flag;
    }
}
