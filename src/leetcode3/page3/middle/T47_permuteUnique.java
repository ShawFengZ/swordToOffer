package leetcode3.page3.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T47_permuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        permute(res, list, nums, visited);
        return res;
    }

    private void permute(List<List<Integer>> res, List<Integer> list, int[] nums, int[] visited){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        int lastUsed = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if (visited[i] == 1 || nums[i] == lastUsed) {
                continue;
            }
            visited[i] = 1;
            list.add(nums[i]);
            permute(res, list, nums, visited);
            lastUsed = nums[i];
            visited[i] = 0;
            list.remove(list.size()-1);
        }
    }
}
