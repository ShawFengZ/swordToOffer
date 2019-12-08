package leetcode2.tree.easy;

import leetcode2.utils.TreeNode;

public class T98_isValidBST {
    /**
     * 验证二叉搜索树
     *
     * 左子树的最右节点
     * 右子树的最左节点
     *
     * 然后再递归
     *
     * 或者中序遍历判断是否是单调递增序列
     * */
    private static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            TreeNode leftMax = root.left;
            while (leftMax.right != null) {
                leftMax = leftMax.right;
            }
            if (leftMax.val >= root.val) {
                return false;
            }
        }
        if (root.right != null) {
            TreeNode rightMax = root.right;
            while (rightMax.left != null) {
                rightMax = rightMax.left;
            }
            if (rightMax.val <= root.val) {
                return false;
            }
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);

        boolean validBST = isValidBST(root);
        System.out.println(validBST);
    }
}
