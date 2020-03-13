package leetcode3.page18.middle;

import java.util.Arrays;
import java.util.Comparator;

public class T179_Solution {

    private static String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return "";
        }
        StringBuilder[] sb = new StringBuilder[nums.length];
        for (int i=0; i<nums.length; i++) {
            sb[i] = new StringBuilder(String.valueOf(nums[i]));
        }
        Arrays.sort(sb, new Comparator<StringBuilder>() {
            @Override
            public int compare(StringBuilder o1, StringBuilder o2) {
                String o1o2 = o1.toString() + o2.toString();
                String o2o1 = o2.toString() + o1.toString();

                return o2o1.compareTo(o1o2);
            }
        });
        if (sb[0].toString().equals("0")) {
            return "0";
        }
        StringBuilder res = new StringBuilder("");
        for (StringBuilder s: sb) {
            res.append(s);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {10, 2};
        String s = largestNumber(nums);
        System.out.println(s);
    }
}
