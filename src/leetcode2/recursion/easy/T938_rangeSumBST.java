package leetcode2.recursion.easy;

import leetcode2.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T938_rangeSumBST {
    /**
     * 二叉搜索树的范围和
     *
     * 思路一：才打败6.7%的提交
     * 1. 中序遍历
     * 2. 计算范围和
     *
     * 思路二：深度优先搜索
     *
     * 思路三：直接递归
     * */
    private static int rangeSumBST3(TreeNode root, int L, int R){
        if (root == null) {
            return 0;
        }
        if (root.val >= L && root.val <= R) {
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        } else if (L > root.val) {
            return rangeSumBST(root.right, L, R);
        } else {
            return rangeSumBST(root.left, L, R);
        }
    }

    static int res;
    private static int rangeSumBST2(TreeNode root, int L, int R){
        res = 0;
        dfs(root, L, R);
        return res;
    }
    private static void dfs(TreeNode root, int L, int R){
        if (root != null) {
            if (root.val <= R && root.val >= L) {
                res += root.val;
            }
            if (L < root.val) {
                dfs(root.left, L, R);
            }
            if (R > root.val) {
                dfs(root.right, L, R);
            }
        }
    }

    private static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        list = midSearch(root, list);
        int sum = 0;
        for (int i=0; i<list.size(); i++) {
            if (list.get(i) >= L && list.get(i) <= R) {
                sum += list.get(i);
            }
        }
        return sum;
    }

    private static List<Integer> midSearch(TreeNode root, List<Integer> list){
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            midSearch(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            midSearch(root.right, list);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);

        int i = rangeSumBST2(root, 7, 15);
        System.out.println(i);
    }
}
