package leetcode2.backtrack.middle;

import java.util.ArrayList;
import java.util.List;

public class T46_permute {
    /**
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     * */
    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int[] visited = new int[nums.length];
        permute(nums, res, new ArrayList<>(), visited);
        return res;
    }

    private static void permute(int[] nums, List<List<Integer>> res,
                                List<Integer> tmpList, int[] visited){
        if (tmpList.size() == nums.length) {
            res.add(new ArrayList<>(tmpList));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            tmpList.add(nums[i]);
            permute(nums, res, tmpList, visited);
            visited[i] = 0;
            tmpList.remove(tmpList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }
}
