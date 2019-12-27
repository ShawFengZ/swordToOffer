package leetcode3.page1.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T15_threeSum {
    /**
     * 三数之和
     * 方法一：回溯(超时)
     * 方法二：双指针
     * */
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<>();
        threeSumUtil(nums, 0, nums.length-1, tmp, res, 0);
        return res;
    }

    private static void threeSumUtil(int[] nums, int start, int end,
                                     List<Integer> tmp, List<List<Integer>> res, int target){
        if (tmp.size() > 3) {
            return;
        }
        if (tmp.size() == 3 && target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i=start; i<= end; i++) {
            if (i != start && nums[i] == nums[i-1]) {//剪枝
                continue;
            }
            tmp.add(nums[i]);
            threeSumUtil(nums, i+1, end, tmp, res, target-nums[i]);
            tmp.remove(tmp.size()-1);
        }
    }

    private static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i+1, h = nums.length-1;
            int sum = 0;
            while (l < h) {
                sum = nums[i] + nums[l] + nums[h];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[h]));
                    while (l < h && nums[l+1] == nums[l])
                        l++;
                    while (l < h && nums[h-1] == nums[h])
                        h--;
                    l++;
                    h--;
                } else if (sum < 0) {
                    l++;
                } else {
                    h--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum2(nums);
        System.out.println(lists);
    }
}
