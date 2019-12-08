package leetcode2.tree.easy;

import leetcode2.utils.TreeNode;

public class T235_lowestCommonAncestor {

    /**
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
     * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度
     * 尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * */
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || (p == null && q == null)) {
            return null;
        }
        if (p == null) {
            return q;
        }
        if (q == null) {
            return p;
        }
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode p = root.left;
        TreeNode q = root.left.right;
        TreeNode treeNode = lowestCommonAncestor(root, p, q);
        System.out.println(treeNode.val);
    }

}
