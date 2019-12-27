package leetcode3.page1.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T18_fourSum {
    /**
     * 四数之和
     *
     * 三数之和的方式
     * */
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i=0; i<nums.length-3; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            //加强过滤
            int min1 = nums[i] + nums[i+1] + nums[i+2] + nums[i+3];
            int max1 = nums[i] + nums[nums.length-1] + nums[nums.length-2] + nums[nums.length-3];
            if (min1 > target) {
                break;
            }
            if (max1 < target) {
                continue;
            }
            for (int j=i+1; j<nums.length-2; j++) {
                //加强过滤
                int min = nums[i] + nums[j] + nums[j+1] + nums[i+2];
                int max = nums[i] + nums[j] + nums[nums.length-1] + nums[nums.length-2];
                if (min > target) {
                    break;
                }
                if (max < target) {
                    continue;
                }
                if (j != i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int low = j+1, high = nums.length-1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low]==nums[low+1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high-1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (sum < target) {
                        while (low < high && nums[low]==nums[low+1]) {
                            low++;
                        }
                        low++;
                    } else {
                        while (low < high && nums[high] == nums[high-1]) {
                            high--;
                        }
                        high--;
                    }
                }
            }
        }
        return res;
    }

    /**
     * [-1,-5,-5,-3,2,5,0,4]
     * -7
     * */
    public static void main(String[] args) {
        int[] nums = {-1,-5,-5,-3,2,5,0,4};
        List<List<Integer>> lists = fourSum(nums, -7);
        System.out.println(lists);
    }
}