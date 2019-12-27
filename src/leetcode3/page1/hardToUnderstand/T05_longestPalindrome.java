package leetcode3.page1.hardToUnderstand;

public class T05_longestPalindrome {
    /**
     * 最长回文子串
     * 方法一：直接遍历查找最长
     * 这就是最佳做法
     * */
    private static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int[] range = new int[2];
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; i++) {
            i = longestPalindrome(chars, i, range);
        }
        return s.substring(range[0], range[1]+1);
    }

    private static int longestPalindrome(char[] chars, int start, int[] range){
        int high = start;
        while (high < chars.length-1 && chars[high+1] == chars[start]) {
            high++;
        }
        int low = start;
        int ans = high;
        while (low > 0 && high < chars.length-1 && chars[low-1] == chars[high+1]) {
            low--;
            high++;
        }
        if (high-low>range[1]-range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "babad";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }
}
