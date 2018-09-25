package leetcode.t03_LogestSubstring;

import java.util.Hashtable;

/**
 * @author zxf
 * @date 2018/9/25 21:29
 */
public class Solution03 {
    /**
     * 题目描述
     *      给定一个字符串，找出其中的最长没有重复字符的子串
     * 解法：
     *      1. 用两个index分别往后移动
     *      2. 当charAt(index2)不在前面的字符中的时候，index2++，
     * */
    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s))
            return 0;
        Hashtable<Integer, Character> hashtable = new Hashtable<>();
        int length = s.length();
        int index1 = 0, index2 = 1;
        int count = 1;
        hashtable.put(index1, s.charAt(index1));
        while (index1<index2 && index2 < length) {
            if (hashtable.contains(s.charAt(index2))) { //有重复的情况
                hashtable.remove(index1);
                if (index2-index1==1) {
                    index1++;
                    index2++;
                    hashtable.put(index1, s.charAt(index1));
                } else {
                    index1++;
                }
            } else { //没有重复的情况
                hashtable.put(index2, s.charAt(index2));
                index2++;
            }
            //每一次操作后检查最长子串是否变化
            int newCount = hashtable.size();
            if (count < newCount) {
                count = newCount;
            }
        }
        return count;
    }
}
