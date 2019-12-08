package leetcode2.tree.easy;

import leetcode2.utils.TreeNode;

public class T111_minDepth {

    /**
     * 给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * */
    private static int minDepth(TreeNode root){
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1+minDepth(root.right);
        }
        if (root.right == null) {
            return 1+minDepth(root.left);
        }
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);

        int i = minDepth(root);
        System.out.println(i);
    }
}
