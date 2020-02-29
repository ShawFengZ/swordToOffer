package leetcode3.page9.easy;

public class Solution168 {

    public static void main(String[] args) {
        System.out.println(convertToTitle(26));
    }

    private static String convertToTitle(int n) {
        if (n <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (n > 26) {
            char tmpInt = (char)(n % 26);
            char tmpChar = (char) (tmpInt +64);
            sb.append(tmpChar);
            n = n/26;
        }
        char tmp = (char) (n + 64);
        sb.append(tmp);
        return sb.reverse().toString();
    }
}
