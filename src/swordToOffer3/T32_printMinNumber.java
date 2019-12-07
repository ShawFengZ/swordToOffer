package swordToOffer3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class T32_printMinNumber {
    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     *
     * 1. 先转换成字符串数组类型；
     * 2. 自定义比较器
     * */
    private String PrintMinNumber(int [] numbers) {
        if (numbers == null ){
            return null;
        }
        if (numbers.length == 0) {
            return "";
        }
        String[] strs = new String[numbers.length];
        for (int i=0; i<strs.length; i++) {
            strs[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s1.compareTo(s2);
            }
        });
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<strs.length; i++) {
            sb.append(strs[i]);
        }

        return sb.toString();
    }
}
