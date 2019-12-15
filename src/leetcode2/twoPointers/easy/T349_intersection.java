package leetcode2.twoPointers.easy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class T349_intersection {
    /**
     * 两个数组的交集
     * 方法一：暴力O(n^3)
     * 方法二：使用set O(m+n), O(m)
     * 方法三：
     * */
    private static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null ||
                nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i1 : nums1) {
            set.add(i1);
        }
        for (int i1: nums2) {
            if (set.contains(i1)) {
                set2.add(i1);
            }
        }
        Iterator it = set2.iterator();
        int[] res = new int[set2.size()];
        int index = 0;
        while (it.hasNext()) {
            res[index++] = (int)it.next();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 6, 2, 9, 1};
        int[] nums2 = {7, 1};
        int[] intersection = intersection(nums1, nums2);
        for (int i: intersection) {
            System.out.print(i + " ");
        }
    }
}
