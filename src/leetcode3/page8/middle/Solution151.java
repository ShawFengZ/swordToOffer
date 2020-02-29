package leetcode3.page8.middle;

public class Solution151 {

    private static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=strs.length-1; i>=0; i--){
            if ("".equals(strs[i])) {
                continue;
            }
            sb.append(strs[i]);
            if (sb.length() != 0 && i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        String trim = reverseWords(s);
        System.out.println(trim);
    }
}
