package swordToOffer3;

public class T2_replaceSpace {
    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     *
     * 思路：
     * 1. 边界条件，输入为空，输入为""的情况；
     * 2.
     * */

    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return "";
        } else if (str.length() == 0) {
            return str.toString();
        }
        //替换
        for (int i=str.length()-1; i>=0; i--) {
            if (' ' == str.charAt(i)) {
                //str.insert(i, "%20");
                str.replace(i, i+1, "%20");
            }
        }
        return str.toString();
    }
}