package leetcode2.backtrack.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T47_permuteUnique {
    /**
     * 全排列带重复数字
     * */
    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        permuteUnique(nums, visited, res, new ArrayList<>());
        return res;
    }

    private static void permuteUnique(int[] nums, int[] visited, List<List<Integer>> res,
                                      List<Integer> tmpList){
        if (nums.length == tmpList.size()) {
            res.add(new ArrayList<>(tmpList));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (visited[i] == 1 || (i > 0 && nums[i] == nums[i-1] && visited[i-1]==0)) {
                continue;
            }
            visited[i] = 1;
            tmpList.add(nums[i]);
            permuteUnique(nums, visited, res, tmpList);
            visited[i] = 0;
            tmpList.remove(tmpList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> lists = permuteUnique(nums);
        System.out.println(lists);
    }
}
