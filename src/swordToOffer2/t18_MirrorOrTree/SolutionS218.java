package swordToOffer2.t18_MirrorOrTree;

/**
 * @author zxf
 * @date 2018/10/23 9:25
 */
public class SolutionS218 {
    /**
     * 题目描述：
     *      操作给定的二叉树，将其变换为源二叉树的镜像。
     * 思路：
     *      1. 递归，将叶子节点先做镜像操作
     * */
    private static TreeNode Mirror(TreeNode root) {
        if (root == null)
            return null;
        if (root.left != null)
            Mirror(root.left);
        if (root.right != null)
            Mirror(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        //root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        TreeNode mirror = Mirror(root);//+ root.right.left.val + " "
        System.out.println(root.val + " " + root.left.val + " " + root.left.left.val + " "
        + root.left.right.val + " " + root.right.val +" " + root.right.right.val);
    }
}
