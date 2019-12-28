package leetcode3.page2.easy;

public class T28_strStr {
    private static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null
                || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        char[] charsHay = haystack.toCharArray();
        char[] charsNeedle = needle.toCharArray();
        for (int i=0; i<=charsHay.length-charsNeedle.length; i++) {
            if (charsHay[i] != charsNeedle[0]) {
                continue;
            }
            int j=0;
            while (j<charsNeedle.length) {
                if (charsHay[i+j] != charsNeedle[j]) {
                    break;
                }
                j++;
                if (j == charsNeedle.length) {
                    return i;
                }
            }

        }
        return -1;
    }

    private static int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ell";
        int strStr = strStr(haystack, needle);
        System.out.println(strStr);
    }
}
