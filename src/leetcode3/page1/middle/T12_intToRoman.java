package leetcode3.page1.middle;

public class T12_intToRoman {
    /**
     * 整数转换罗马数字
     *
     * 下面方式更见简单快捷
     * */
    private static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] repr = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder("");
        for (int i=0; i<values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(repr[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = intToRoman(58);
        System.out.println(s);
    }
}
