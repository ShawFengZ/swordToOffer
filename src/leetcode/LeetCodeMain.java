package leetcode;

import leetcode.t03_LogestSubstring.Solution03;
import leetcode.t04_medianOf.Solution04;

/**
 * @author zxf
 * @date 2018/9/25 20:09
 */
public class LeetCodeMain {
    public static void main(String[] args) {
        //01. two sum
        /*int[] nums = {2, 8, 3, 70,15};
        int[] twoSum1 = Solution01.twoSum2(nums, 78);
        for (int s: twoSum1){
            System.out.print(s+" ");
        }*/

        //02. add Two numbers
        /*ListNode02 l1 = new ListNode02(1);
        l1.next = new ListNode02(8);
        //l1.next.next = new ListNode02(3);

        ListNode02 l2 = new ListNode02(0);
        //l2.next = new ListNode02(6);
        //l2.next.next = new ListNode02(4);

        ListNode02 l3 = Solution2.addTwoNumbers2(l1, l2);
        System.out.println(l3.val + "->" + l3.next.val);*/

        /*ListNode02 l1 = new ListNode02(5);
        ListNode02 l2 = new ListNode02(5);
        ListNode02 l3 = Solution2.addTwoNumbers2(l1, l2);
        System.out.println(l3.val+","+l3.next.val);*/

        //03. 最长子串的数
        /*String s = "abcaaaa";
        int length = Solution03.lengthOfLongestSubstring(s);
        System.out.println(length);*/

        //04. 两个排序数列的中位数
        /*int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double medianSortedArrays = Solution04.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);*/

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        double medianSortedArrays1 = Solution04.findMedianSortedArrays(nums3, nums4);
        System.out.println(medianSortedArrays1);
    }
}
