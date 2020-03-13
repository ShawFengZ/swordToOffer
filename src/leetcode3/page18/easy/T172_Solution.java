package leetcode3.page18.easy;

import java.util.Arrays;
import java.util.Comparator;

public class T172_Solution {

    private static long jiechen(int n) {
        long res = 1;
        while (n > 0) {
            res *= n--;
        }
        return res;
    }
    public static void main(String[] args) {
        long jiechen = jiechen(12);
        System.out.println(jiechen);
        String[] nums = {"1", "2", "3"};

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String order1 = o1+o2;
                String order2 = o2+o1;
                return order2.compareTo(order1);
            }
        });
    }
}

