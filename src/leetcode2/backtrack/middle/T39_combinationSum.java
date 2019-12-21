package leetcode2.backtrack.middle;

import java.util.ArrayList;
import java.util.List;

public class T39_combinationSum {

    /**
     * 给定一个无重复元素的数组candidates和一个目标数target，
     * 找出candidates中所有可以使数字和为 target 的组合。
     *
     * candidates 中的数字可以无限制重复被选取。
     * */
    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        backtrack(candidates, target, res, 0, new ArrayList<>());
        return res;
    }

    private static void backtrack(int[] candidates, int target, List<List<Integer>> res,
                                  int i, ArrayList<Integer> tmpList){
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(tmpList));
            return;
        }
        for (int start=i; start<candidates.length; start++) {
            tmpList.add(candidates[start]);
            backtrack(candidates, target-candidates[start], res, start, tmpList);
            tmpList.remove(tmpList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> lists = combinationSum(candidates, target);
        System.out.println(lists);
    }
}
