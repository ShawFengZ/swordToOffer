package leetcode2.tree.middle;

import leetcode2.utils.TreeNode;

public class T222_countNodes {
    /**
     * 给出一个完全二叉树，求出该树的节点个数。
     *
     * 1. 先计算左右子树的最大高度
     *      如果相等说明左边是一个完全满二叉树
     *      如果不相等说明左右均可能是非完全二叉树
     * 2. 递归
     * */
    private static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepthOfTree(root.left);
        int right = getDepthOfTree(root.right);
        if (left == right) {
            return (int) Math.pow(2, left) + countNodes(root.right);
        } else {
            return 1+countNodes(root.left)+ countNodes(root.right);
        }
    }

    private static int getDepthOfTree(TreeNode root){
        if (root == null) {
            return 0;
        }
        int cnt = 1;
        while (root.left != null) {
            root = root.left;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        int nodes = countNodes(root);
        System.out.println(nodes);
    }
}
