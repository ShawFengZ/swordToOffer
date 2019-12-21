package leetcode2.backtrack.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T40_combinationSum2 {
    /**
     * 组合总数II
     *
     * 不能重复
     * */
    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        combination(candidates, 0, target, res, new ArrayList<>());
        return res;
    }

    private static void combination(int[] candidates, int i, int target,
                                    List<List<Integer>> res, List<Integer> tmpList){
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(tmpList));
            return;
        }
        for (int start=i; start<candidates.length; start++) {
            if (start > i && candidates[start] == candidates[start-1]) {
                continue;
            }
            tmpList.add(candidates[start]);
            combination(candidates, start+1, target-candidates[start], res, tmpList);
            tmpList.remove(tmpList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        System.out.println(lists);
    }
}
