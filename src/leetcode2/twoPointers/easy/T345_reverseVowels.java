package leetcode2.twoPointers.easy;

public class T345_reverseVowels {
    /**
     * 反转字符串中的元音字母
     *
     * 元音字母：a、e、i、o、u
     * */
    private static String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int low = 0, high = chars.length-1;
        while (low < high) {
            if (!(chars[low] == 'a' || chars[low] == 'e'
                    ||chars[low] == 'i' ||chars[low] == 'o'
            || chars[low] == 'u' || chars[low] == 'A' || chars[low] == 'E'
                    ||chars[low] == 'I' ||chars[low] == 'O'
                    || chars[low] == 'U')) {
                low++;
                continue;
            }
            if (!(chars[high] == 'a' || chars[high] == 'e'
                    ||chars[high] == 'i' ||chars[high] == 'o'
                    || chars[high] == 'u' || chars[high] == 'A' || chars[high] == 'E'
                    ||chars[high] == 'I' ||chars[high] == 'O'
                    || chars[high] == 'U')) {
                high--;
                continue;
            }
            char tmp = chars[low];
            chars[low] = chars[high];
            chars[high] = tmp;
            low++;
            high--;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String str = "hello";
        String s = reverseVowels(str);
        System.out.println(s);
    }
}
