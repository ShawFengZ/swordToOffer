package swordToOffer3;

import swordToOffer3.utils.TreeNode;

public class T39_isBalanced_Solution {
    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     *
     * 思路：
     * 计算左子树的最大高度和右子树的最大高度，然后比较
     * */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null ) {
            return true;
        }
        if (IsBalanced_Solution(root.left) || IsBalanced_Solution(root.right)) {
            return false;
        }
        int left = getHeightOfTree(root.left);
        int right = getHeightOfTree(root.right);
        return Math.abs(left-right) <= 1;
    }

    private int getHeightOfTree(TreeNode root){
        if (root == null) {
            return 0;
        }
        return 1+Math.max(getHeightOfTree(root.left), getHeightOfTree(root.right));
    }
}
