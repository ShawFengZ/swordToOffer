package leetcode3.page3.middle;

import java.util.ArrayList;
import java.util.List;

public class T46_permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        int[] visited = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        permute(res, list, nums, visited);
        return res;
    }

    private void permute(List<List<Integer>> res, List<Integer> list, int[] nums, int[] visited){
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (visited[i] == 1) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = 1;
            permute(res, list, nums, visited);
            visited[i] = 0;
            list.remove(list.size()-1);
        }
    }
}
