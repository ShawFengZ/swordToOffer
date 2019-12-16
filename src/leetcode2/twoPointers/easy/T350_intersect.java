package leetcode2.twoPointers.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class T350_intersect {
    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     * 方法一：map+list
     * 1. 先将其中一个数组放到map中，并记录次数
     * 2. 遍历另一个数组，如果map中有，则记录该数字
     *
     * 方法二：排序+双指针(更快)
     * 1. 两个数组分别排序
     * 2. 两个指针分别在两个数组上移动寻找相同的数字
     * */
    private static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        for (int i: nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            } else {
                map.put(i, 1);
            }
        }
        for (int i: nums2) {
            if (map.containsKey(i)) {
                list.add(i);
                if (map.get(i) == 1) {
                    map.remove(i);
                } else {
                    map.put(i, map.get(i)-1);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static int[] intersect2(int[] nums1, int[] nums2){
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i1=0, i2=0;
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] == nums2[i2]) {
                list.add(nums1[i1]);
                i1++;
                i2++;
            } else if (nums1[i1] < nums2[i2]) {
                i1++;
            } else {
                i2++;
            }
        }
        int[] res = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] intersect = intersect2(nums1, nums2);
        for (int i: intersect){
            System.out.print(i + " ");
        }
    }

}
