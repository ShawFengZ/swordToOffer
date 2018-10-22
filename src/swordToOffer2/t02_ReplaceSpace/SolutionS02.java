package swordToOffer2.t02_ReplaceSpace;

/**
 * @author zxf
 * @date 2018/10/19 16:04
 */
public class SolutionS02 {
    /**
     * 字符串替换空格;
     *      给定一个字符串，将其中的空格替换成特定的字符串"%20"
     * 思路：
     *      就直接遍历替换呗。这种方式的时间复杂度不是O(n^2)，但是也不是最佳的办法。
     * 思路二：
     *      1. 先遍历一遍求出需要替换的空格的数量。并计算替换后的字符串的长度
     *      2. 两个指针，p1指向未替换的字符串的尾部，p2指向替换后的字符串的尾部。
     *      3. p1位置的字符赋值到p2位置，如果遇到空格，将%20放到p1位置处。
     * */
    private static String replaceSpace(StringBuffer str) {
        int start = 0;
        int end = str.length()-1;
        while (start <= end) {
            if (str.charAt(start) == ' '){
                str.replace(start, start+1, "%20");
                end += 2;
                start += 2;
            }
            start++;
        }
        return str.toString();
    }

    private static String replaceSpace2(StringBuffer str) {
        int index1 = 0,count=0;
        while (index1 < str.length()) {
            if (str.charAt(index1)==' ')
                count++;
            index1++;
        }
        index1--;
        str.setLength(str.length()+count*2);
        int index2 = str.length();
        //将index1位置的字符放到index2处
        while (index1 >= 0 && index2 >= index1) {
            if (str.charAt(index1) != ' ') {
                str.replace(index2-1, index2, str.substring(index1, index1+1));
                index2--;
                index1--;
            } else { //是空格的时候
                str.replace(index2-3, index2, "%20");
                index2 -= 3;
                index1--;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        String s = replaceSpace2(str);
        //String s = str.replace(0,1, "55").toString();
        System.out.println(s);
    }
}
