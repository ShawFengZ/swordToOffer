package leetcode2.tree.easy;

import leetcode2.utils.TreeNode;

public class T110_isBalanced {
    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * */
    private static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftMaxDep = getMaxHeight(root.left);
        int rightMaxDep = getMaxHeight(root.right);
        if (Math.abs(leftMaxDep-rightMaxDep) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getMaxHeight(TreeNode root){
        if (root == null) {
            return 0;
        }
        return Math.max(getMaxHeight(root.left), getMaxHeight(root.right))+1;
    }
}