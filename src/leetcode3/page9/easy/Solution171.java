package leetcode3.page9.easy;

public class Solution171 {

    private static int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] strs = s.toCharArray();
        int res = 0;
        for(char c: strs){
            res = res * 26 + c - 64;
        }
        return res;
    }

    public static void main(String[] args) {
        int number = titleToNumber("ZY");
        System.out.println(number);
    }
}
