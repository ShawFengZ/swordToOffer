package leetcode2.tree.middle;

import leetcode2.utils.TreeNode;

import java.util.Stack;

public class T236_lowestCommonAncestor {

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
     * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度
     * 尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 思路：使用中序遍历的非递归方式模拟
     * */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || (p == null && q == null)) {
            return null;
        }
        if (p == q) {
            return p;
        }
        if (q == null) {
            return p;
        }
        if (p == null) {
            return q;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        boolean pFind = false;
        boolean qFind = false;
        while (tmp != null || !stack.isEmpty()) {
            if (tmp != null) {
                if (tmp == p || tmp == q) {

                }
                stack.push(tmp);
                tmp = tmp.left;
            } else {
                tmp = stack.pop();
                if (tmp.right != null) {
                    tmp = tmp.right;
                }
            }
        }
        return null;
    }
}
