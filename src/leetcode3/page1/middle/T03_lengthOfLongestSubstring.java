package leetcode3.page1.middle;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class T03_lengthOfLongestSubstring {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 使用dp效率更高
     * */
    private static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }
        Queue<Character> queue = new ArrayDeque<>();
        int low = 0, high = 1;
        int maxLength = 1;
        queue.add(s.charAt(low));
        while (high <s.length() && (low < high || queue.size() == 0)) {
            if (!queue.contains(s.charAt(high))) {
                queue.add(s.charAt(high));
                high++;
            } else {
                queue.poll();
                low++;
            }
            if (high-low > maxLength) {
                maxLength = high-low;
            }
        }
        return maxLength;
    }

    //81%
    private static int lengthOfLongestSubstring2(String s) {
        int start=0;
        int[] dp = new int[s.length()+1];
        for (int i=0; i<s.length(); i++) {
            if (s.substring(start, i).indexOf(s.charAt(i)) != -1) {//找到了相同的字符，更新l
                start = s.indexOf(s.charAt(i), start)+1;
            }
            dp[i+1] = Math.max(dp[i], i-start+1);
        }
        return dp[s.length()];
    }

    //最佳的做法
    private static int lengthOfLongestSubstring3(String s) {
        int maxLength = 0;
        char[] chars = s.toCharArray();
        int leftIndex = 0;
        for (int i=0; i<chars.length; i++) {
            for (int innerIndex=leftIndex; innerIndex < i; innerIndex++) {
                if (chars[innerIndex] == chars[i]) {
                    maxLength = Math.max(maxLength, i-leftIndex);
                    leftIndex = innerIndex+1;
                    break;
                }
            }
        }
        return Math.max(chars.length-leftIndex, maxLength);
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }
}
