package leetcode.t28_ImplementStrStr;

/**
 * @author zxf
 * @date 2018/10/16 19:40
 */
public class Solution28 {

    /**
     * 题目描述：
     *      即找子串
     * */
    public static int strStr(String haystack, String needle) {
        if ("".equals(haystack) || haystack == null)
            return -1;
        if ("".equals(needle))
            return 0;
        int hayLength = haystack.length();
        int neLength = needle.length();
        int index = -1;
        for (int i = 0; i <= hayLength-neLength; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, i+neLength).equals(needle)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
}
