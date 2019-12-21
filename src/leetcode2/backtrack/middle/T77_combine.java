package leetcode2.backtrack.middle;

import java.util.ArrayList;
import java.util.List;

public class T77_combine {
    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * */
    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n) {
            return res;
        }
        combine(1, n, k, res, new ArrayList<>());
        return res;
    }

    private static void combine(int min, int max, int k,
                                List<List<Integer>> res, List<Integer> tmpList){
        if (k == 0) {
            res.add(new ArrayList<>(tmpList));
            return;
        }
        for (int i=min; i<=max-k+1; i++) {
            tmpList.add(i);
            combine(i+1, max, k-1, res, tmpList);
            tmpList.remove(tmpList.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }
}
