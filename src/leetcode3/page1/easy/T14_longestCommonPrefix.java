package leetcode3.page1.easy;

public class T14_longestCommonPrefix {
    /**
     * 最长公共前缀
     * 思路一：暴力法
     * 方法二：更简单
     * */
    private static String longestCommonPrefix(String[] strs) {
        int maxlen = Integer.MAX_VALUE;
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i=0; i<strs.length; i++) {
            if (maxlen > strs[i].length()) {
                maxlen = strs[i].length();
            }
        }
        for (int i=0; i<maxlen; i++) {
            for (int j=0; j<strs.length-1; j++) {
                if (strs[j].charAt(i) != strs[j+1].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, maxlen);
    }

    //最佳做法，使用startWith函数
    private static String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String reg = strs[0];
        for (String str: strs) {
            while (!str.startsWith(reg)) {
                if (reg.length() == 1) {
                    return "";
                }
                reg = reg.substring(0, reg.length()-1);
            }
        }
        return reg;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flowight"};
        String commonPrefix = longestCommonPrefix(strs);
        System.out.println(commonPrefix);
    }
}
