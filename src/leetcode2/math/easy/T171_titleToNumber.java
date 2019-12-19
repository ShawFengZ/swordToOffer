package leetcode2.math.easy;

public class T171_titleToNumber {
    private static int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int sum = 0;
        int tmp = 1;
        for (int i=chars.length-1; i>=0; i--) {
            sum += (chars[i]-'A'+1) * tmp;
            tmp *= 26;
        }
        return sum;
    }

    public static void main(String[] args) {
        int number = titleToNumber("EV");
        System.out.println(number);
    }
}
