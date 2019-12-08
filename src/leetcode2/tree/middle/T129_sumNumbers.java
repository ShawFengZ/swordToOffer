package leetcode2.tree.middle;

import leetcode2.utils.TreeNode;

public class T129_sumNumbers {

    /**
     * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
     *
     * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
     *
     * 计算从根到叶子节点生成的所有数字之和。
     * */
    private static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        int sum = root.val;
        res += sumNumbers(root, res, sum);
        return res;
    }

    private static int sumNumbers(TreeNode root, int res, int sum) {
        if (root.left == null && root.right == null) {
            res += sum;
            return res;
        }
        if (root.left != null) {
            sum = sum * 10 +  root.left.val;
            res = sumNumbers(root.left, res, sum);
            sum = (sum - root.left.val)/10;
        }
        if (root.right != null) {
            sum = sum * 10 +  root.right.val;
            res = sumNumbers(root.right, res, sum);
            sum = (sum - root.right.val)/10;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        /*root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);*/
        int res = sumNumbers(root);

        System.out.println(res);
    }
}
