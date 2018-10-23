package swordToOffer2.t17_HasSubtree;

/**
 * @author zxf
 * @date 2018/10/23 9:04
 */
public class SolutionS217 {
    /**
     * 题目描述：
     *      输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     * 思路：
     *      1. 遍历root1找root2；
     *      2. 如果找到则在root1的左子树中找root2的左子树，右子树中找右子树
     *      3. 如果没找到返回false.
     * */
    private static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null || root1 == null)
            return false;
        if (root1.val == root2.val) {
            boolean left = true;
            boolean right = true;
            if (root2.left != null)
                left = HasSubtree(root1.left, root2.left);
            if (root2.right != null)
                right = HasSubtree(root1.right, root2.right);
            if (left && right)
                return true;
            else {
                return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
            }
        } else {
            return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
    }

    //判断是否是子树
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);

        boolean b = HasSubtree(root1, root2);
        System.out.println(b);
    }
}
