package leetcode2.tree.easy;

import leetcode2.utils.TreeNode;

public class T114_flatten {
    /**
     * 给定一个二叉树，原地将它展开为链表。
     * */
    private static void flatten(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }
        TreeNode p = root;
        while (p != null) {
            if (p.left == null) {
                p = p.right;
            } else {
                TreeNode q = p.right;
                p.right = p.left;
                p.left = null;
                TreeNode t = p.right;
                while (t.right != null) {
                    t = t.right;
                }
                t.right = q;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flatten(root);
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }
}
