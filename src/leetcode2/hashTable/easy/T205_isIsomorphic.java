package leetcode2.hashTable.easy;

import java.util.HashMap;
import java.util.Map;

public class T205_isIsomorphic {
    /**
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     *
     * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
     *
     * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。
     * 两个字符不能映射到同一个字符上，但字符可以映射自己本身。
     * */
    private static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        for (int i=0; i<chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                if (map.containsValue(chart[i])) {
                    return false;
                }
                map.put(chars[i], chart[i]);
            } else if (map.get(chars[i]) != chart[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ab";
        String t = "aa";
        boolean isomorphic = isIsomorphic(s, t);
        System.out.println(isomorphic);
    }
}
