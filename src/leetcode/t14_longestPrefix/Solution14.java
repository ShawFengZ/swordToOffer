package leetcode.t14_longestPrefix;

/**
 * @author zxf
 * @date 2018/10/15 21:06
 */
public class Solution14 {
    /**
     * 输入一个字符串数组，找出最长子串，如果没有，输出空
     * 思路：
     *      1. 依次遍历，找出第一个和第二个的公共前缀
     *      2. 找出第一个和第三个之间的公共前缀， 如果更短，则就是它
     *      3. 直到找到最后一个字符串为止
     * */
    public static String longestCommonPrefix(String[] strs){
        if (strs == null || strs.length <= 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        String commonStr = strs[0];
        for (int i = 1; i< strs.length; i++) {
            commonStr = getPrefix(commonStr, strs[i]);
            if ("".equals(commonStr))
                break;
        }
        return commonStr;
    }

    private static String getPrefix(String str1, String str2){
        if (str1 == null || str2 == null || "".equals(str1) || "".equals(str2))
            return "";
        String ans = "";
        int index1 = 0, index2 = 0;
        while (index1 < str1.length() && index2 < str2.length()) {
            if (str1.charAt(index1) == str2.charAt(index2)) {
                ans += str1.charAt(index1);
            } else {
                break;
            }
            index1++;
            index2++;
        }
        return ans;
    }
}
