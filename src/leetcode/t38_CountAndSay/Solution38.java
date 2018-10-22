package leetcode.t38_CountAndSay;

/**
 * @author zxf
 * @date 2018/10/18 13:48
 */
public class Solution38 {
    /**
     * 题目描述：
     *      也不太懂
     * 思路：
     *      递归
     * */
    public static String countAndSay(int n) {
        if (n==1)
            return "1";
        int i = 2;
        String ans = "1";
        while (i <= n) {
            ans = countAndSay(ans);
            i++;
        }
        return ans;
    }

    private static String countAndSay(String ans){
        if (ans.length() == 1) {
            return "1"+ans;
        }
        ans += ".";
        int count = 1;
        String res = "";
        int i = 1;
        while ( i<ans.length()) {
            if (ans.charAt(i) == ans.charAt(i-1)) {
                count++;
            } else {
                res += String.valueOf(count);
                res += ans.charAt(i-1);
                count = 1;
            }
            i++;
        }
        return res;
    }
}
