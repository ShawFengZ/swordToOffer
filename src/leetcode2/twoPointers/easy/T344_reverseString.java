package leetcode2.twoPointers.easy;

public class T344_reverseString {
    private static void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        int low = 0, high = s.length-1;
        while (low < high) {
            char tmp = s[low];
            s[low] = s[high];
            s[high] = tmp;
            low++;
            high--;
        }

        System.out.println(String.valueOf(s));
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
    }
}
