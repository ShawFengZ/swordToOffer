package leetcode2.recursion.middle;

import leetcode2.utils.ListNode;
import leetcode2.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T894_allPossibleFBT {
    /**
     * 所有可能的满二叉树
     *
     * 思路：
     * 1. 偶数不能构成二叉树
     * 2. 奇数分为左右递归
     * */
    private List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N % 2 == 0) {
            return res;
        }
        if (N == 1) {
            TreeNode root = new TreeNode(0);
            res.add(root);
            return res;
        }
        for (int i=1; i<N; i++) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N-i-1);
            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    TreeNode head = new TreeNode(0);
                    head.left = l;
                    head.right = r;
                    res.add(head);
                }
            }
        }
        return res;
    }

}
