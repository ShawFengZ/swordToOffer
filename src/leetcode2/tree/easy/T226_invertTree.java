package leetcode2.tree.easy;

import leetcode2.utils.TreeNode;

public class T226_invertTree {
    /**
     *翻转一棵二叉树。
     * */
    private static TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
       // root.right = new TreeNode(3);

        TreeNode treeNode = invertTree(root);
        System.out.println(treeNode.left.val);
    }


}
