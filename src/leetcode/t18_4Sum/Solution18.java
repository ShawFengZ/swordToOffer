package leetcode.t18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zxf
 * @date 2018/10/16 10:54
 */
public class Solution18 {
    /**
     * 给定一个数组，一个目标值，找出4个数字的和为目标，返回四个值
     * */
    public static List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return list;
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            /*if (i > 0 && nums[i]==nums[i-1])
                continue;*/
            int start = i+1, end = nums.length-1;
            int newTarget = target - nums[i];
            List<List<Integer>> lists = threeSum(nums, start, end, newTarget);
            if (lists != null && lists.size() > 0){
                for (List<Integer> l: lists) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.addAll(l);
                    if (!list.contains(tempList))
                        list.add(tempList);
                }
            }
        }
        return list;
    }

    //3Sum
    private static List<List<Integer>> threeSum(int[] nums, int start, int end, int target){
        if (nums == null || nums.length < 4 || end-start < 2)
            return null;
        List<List<Integer>> list = new ArrayList<>();
        for (int i=start; i<end-1; i++) {
            int left = i+1;
            int right = end;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[left]);
                    tempList.add(nums[right]);
                    list.add(tempList);
                    while (left < right && nums[left] == nums[left+1])
                        left++;
                    while (left < right && nums[right] == nums[right-1])
                        right--;
                    left++;
                    right--;
                } else if ( sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }
}
