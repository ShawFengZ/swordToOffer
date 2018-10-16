package leetcode.t15_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zxf
 * @date 2018/10/15 21:24
 */
public class Solution15 {

    /**
     * 给定一个数组，选取三个数，使之和为0，不能有重复的
     * 思路; 该方法超出时间复杂度
     *      1. 将3sum转化为2sum，选取一个数，目标数减去这个数，在剩下的数组中利用2sum求解
     *      2. 先排序
     * 思路二：
     *
     * */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3){
            return ans;
        }
        Arrays.sort(nums);
        int temp = nums[0];
        List<List<Integer>> list1 = twoSum(nums, 1, 0-temp);
        if (list1.size() > 0) {
            for (List<Integer> l : list1) {
                if (l != null && l.size() == 2) {
                    l.add(temp);
                    if (!ans.contains(l))
                        ans.add(l);
                }
            }
        }
        for (int i = 1; i < nums.length-2; i++) {
            if (nums[i-1] == nums[i])//去掉重复的
                continue;
            List<List<Integer>> list = twoSum(nums, i + 1, 0 - nums[i]);
            if (list.size() > 0) {
                for (List<Integer> l : list) {
                    if (l != null && l.size() == 2) {
                        l.add(nums[i]);
                        if (!ans.contains(l))
                            ans.add(l);
                    }
                }
            }
        }
        return ans;
    }

    //如果有多组，则找不出来
    private static List<List<Integer>> twoSum(int[] nums, int start, int target){
        if (nums == null || nums.length <= 1 || start>= nums.length)
            return null;
        int index1 = start, index2 = nums.length - 1;
        List<List<Integer>> list = new ArrayList<>();
        while (index1 < index2) {
            int sum = nums[index1] + nums[index2];
            if (sum < target) {
                index1 ++;
            } else if (sum > target) {
                index2 --;
            } else {
                List<Integer> list1 = new ArrayList<>();
                list1.add(nums[index1]);
                list1.add(nums[index2]);
                list.add(list1);
                index1++;
            }
        }
        return list;
    }

    //上面的方法时间复杂度太大，尝试下面的方法,AC
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i=0; i<nums.length-2; i++) {
            int left = i+1;
            int right = nums.length - 1;
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    result.add(Arrays.asList(new Integer[]{nums[i], nums[left], nums[right]}));
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right-1])
                        right--;
                    right--;
                    left++;
                } else if (sum > 0){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
