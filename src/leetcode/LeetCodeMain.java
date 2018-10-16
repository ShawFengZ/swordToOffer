package leetcode;

import leetcode.t20_ValidParentheses.solution20;
import leetcode.t22_GenerateParentheses.Solution22;
import leetcode.t26_RemoveDuplicatesFromSortedArray.Solution26;
import leetcode.t27_removeElement.Solution27;
import leetcode.t28_ImplementStrStr.Solution28;
import leetcode.t30_SubStringWithConcatenation.Solution30;
import t29_getLeastNumbers.Solution29;
import t6_minNumberInRotateArray.Solution;

import java.util.List;

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

        /*int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        double medianSortedArrays1 = Solution04.findMedianSortedArrays(nums3, nums4);
        System.out.println(medianSortedArrays1);*/

        //07.翻转整数
        /*int num = 1534236469;
        int reverse = Solution07.reverse(num);
        System.out.println(reverse);*/

        //09. 判断一个数字是否是回文数
        /*int num = 131;
        boolean palindrome = Solution09.isPalindrome2(num);
        System.out.println(palindrome);*/

        //11. Container With Most Water
        /*int[] height = {1,8,6,2,5,4,8,3,7};
        int maxArea = Solution11.maxArea(height);
        System.out.println(maxArea);*/

        //12. Integer to Roman
        /*int num = 9;
        String intToRoman = Solution12.intToRoman(num);
        System.out.println(intToRoman);*/


        //14. Longest Common Prefix
        /*String[] strs = {"flower","flower","flower"};
        String commonPrefix = Solution14.longestCommonPrefix(strs);
        System.out.println(commonPrefix);*/

        //15. 3Sum
        /*int[] nums  = {-1, 0, 1, 2, -1, -4}; //{-2, 0, 1, 1, 2};
        List<List<Integer>> lists = Solution15.threeSum2(nums);
        for (List<Integer> l1: lists) {
            System.out.println(l1.toString());
        }*/

        //16. 3sumCloset
        /*int[] nums = {-1, 0, 1, 1, 55};
        int sumClosest = Solution16.threeSumClosest(nums, 3);
        System.out.println(sumClosest);*/

        //17. Letter Combinations of a Phone Number
        /*String digits = "";
        List<String> list = Solution17.letterCombinations(digits);
        for (String s: list) {
            System.out.println(s.toString());
        }*/

        //18. 4sum
        /*int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        List<List<Integer>> lists = Solution18.fourSum(nums, 0);
        for (List<Integer> l: lists) {
            System.out.println(l.toString());
        }*/

        //19. Remove Nth Node From End of List

        /*ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        *//*head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);*//*
        ListNode listNode = Solution19.removeNthFromEnd(head, 2);
        while (listNode!=null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }*/

        //20. Valid Parentheses
        /*String s = "";
        boolean valid = solution20.isValid(s);
        System.out.println(valid);*/

        //21. Merge Two Sorted Lists

        //22. Generate Parentheses
        /*List<String> list = Solution22.generateParenthesis(3);
        System.out.println(list.toString());*/

        //26. Remove Duplicates from Sorted Array
        /*int[] nums = {1,1,2};
        Solution26.removeDuplicates(nums);*/

        //27. Remove Element
        /*int[] nums = {0,1,2,2,3,0,4,2};
        int i = Solution27.removeElement(nums, 2);
        System.out.println(i);*/

        //28. Implement strStr()
        /*String hayStack = "hello";
        String needle = "";
        int str = Solution28.strStr(hayStack, needle);
        System.out.println(str);*/

        //29. Divide Two Integers
        /*int divide = leetcode.t29_DivideTwoInteger.Solution29.divide(-2147483648, -1);
        System.out.println(divide);*/

        //30. Substring with Concatenation of All Words"barfoothefoobarman";//{"foo","bar"};//
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","best"};

        String s1 = "a";
        String[] words1 = {"a"};
        /*List<Integer> substring = Solution30.findSubstring(s, words);
        System.out.println(substring.toString());
*/
        List<Integer> subString1 = Solution30.findSubstring(s1, words1);
        System.out.println(subString1.toString());
    }
}
