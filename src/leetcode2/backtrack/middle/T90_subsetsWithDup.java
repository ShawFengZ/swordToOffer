package leetcode2.backtrack.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T90_subsetsWithDup {
    /**
     * 子集
     * */
    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        findSubsets(nums, 0, new ArrayList<>(), res);
        res.add(new ArrayList<>());
        return res;
    }

    private static void findSubsets(int[] nums, int start, List<Integer> list, List<List<Integer>> res){
        for (int i=start; i<nums.length; i++) {
            if (start == i || nums[i] != nums[i-1]) {
                list.add(nums[i]);
                findSubsets(nums, i+1, list, res);
                res.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> lists = subsetsWithDup(nums);
        System.out.println(lists);
    }
}
