package leetcode2.recursion.hard;

import leetcode2.utils.TreeNode;

public class T687_longestUnivaluePath {
    /**
     * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。
     * 这条路径可以经过也可以不经过根节点。
     *
     * 采用递归的方式做
     * */
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        getUnivaluePath(root);
        return ans;
    }

    private int getUnivaluePath(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = getUnivaluePath(root.left);
        int right = getUnivaluePath(root.right);
        if (root.left != null && root.val == root.left.val) {
            left += 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right += 1;
        }
        ans = Math.max(ans, left + right);
        return Math.max(left, right);
    }
}
