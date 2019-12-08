package leetcode2.tree.middle;

import leetcode2.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T113_pathSum {

    /**
     * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
     * */
    private static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        pathSumUtil(root, sum-root.val, res, list);
        return res;
    }

    private static void pathSumUtil(TreeNode root, int sum,
                                            List<List<Integer>> res, List<Integer> list){
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(list));
        }
        if (root.left != null) {
            list.add(root.left.val);
            pathSumUtil(root.left, sum-root.left.val, res, list);
            list.remove(list.size()-1);
        }
        if (root.right != null) {
            list.add(root.right.val);
            pathSumUtil(root.right, sum-root.right.val, res, list);
            list.remove(list.size()-1);
        }
    }
}
