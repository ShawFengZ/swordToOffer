package leetcodeDifficult.t5_LongestPalindromicSubString;

/**
 * @author zxf
 * @date 2018/10/19 10:20
 */
public class SolutionD05 {
    /**
     * 给定一个字符串，找出最长的回文子串
     * 思路一：两侧比较法
     *         时间复杂度O(n^3)
     * */
    public static String longestPalindrome(String s) {
        int maxPalinLength = 0;
        String longestPalindrome = null;
        int length = s.length();

        //检查所有可能的子串
        for (int i=0; i < length; i++) {
            for (int j = i+1; j < length; j++){
                int len = j - i;
                String curr = s.substring(i, j+1);
                if (isPalindrome(curr)) {
                    if (len > maxPalinLength) {
                        longestPalindrome = curr;
                        maxPalinLength = len;
                    }
                }
            }
        }
        return longestPalindrome;
    }

    //判断是否是回文字符串
    private static boolean isPalindrome(String s){
        for (int i = 0; i<s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1))
                return false;
        }
        return true;
    }

    /**
     * 动态规划：
     *
     * */

    /**
     * 方法三：中心扩展法
     *      由于回文字符串是中心对称的，所以要假设我们从下标i出发，用两个指针向i的两边出发，推断是否相等。
     *      仅仅需要对0到n-1的下标做此操作，就能求出最长的回文子串。
     *      注意，回文字符串有奇偶对称之分，需要做出判断
     * */
    public static String longestPalindrome2(String s){
        if (s.isEmpty())
            return null;
        if (s.length() == 1)
            return s;
        String longest = s.substring(0, 1);
        for (int i=0; i<s.length(); i++) {
            //get longest palindrome with center i(奇对称的情况)
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length())
                longest = tmp;
            //get longest palindrome with center of i, i+1(偶对称的情况)
            tmp = helper(s, i, i+1);
            if (tmp.length() > longest.length())
                longest = tmp;
        }
        return longest;
    }

    private static String helper(String s, int begin, int end){
        while (begin >=0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin+1, end);
    }

    public static void main(String[] args) {
        //判断是不是回文字符串
        //System.out.println(isPalindrome("abtbas"));
        //测试方法一
        System.out.println(longestPalindrome("cbbd"));
    }
}
