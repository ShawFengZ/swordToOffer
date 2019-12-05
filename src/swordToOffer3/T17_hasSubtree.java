package swordToOffer3;

import swordToOffer3.utils.TreeNode;

public class T17_hasSubtree {

    /**
     * 树的子结构：
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     *
     * 递归
     * */
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null || root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        } else {
            return HasSubTreeUtil(root1, root2) ||
                    HasSubtree(root1.left, root2) ||
                    HasSubtree(root1.right, root2);
        }
    }

    private static boolean HasSubTreeUtil(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val==root2.val &&
                HasSubTreeUtil(root1.left, root2.left) &&
                HasSubTreeUtil(root1.right, root2.right);
    }
}
