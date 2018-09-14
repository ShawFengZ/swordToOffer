package book.t28_isSymmertrical;

/**
 * @author zxf
 * @date 2018/9/10 20:33
 */
public class SolutionBook28 {
    /**
     * 题目：
     *      请实现一个函数，用来判断一棵二叉树是不是对称的。
     *      如果一棵二叉树的镜像和它是一样的，则是对称的。
     * 思路：
     *      1. 鲁棒性：判断根节点是否为空
     *      2. 如果不为空判断是否为叶子节点
     *          是叶子节点就返回true
     *      3. 不是根节点就判断左右子节点是否相同
     * 思路错误：
     *      画个图就直到错在哪里了
     * */

    /*public static boolean isSymmertrical (t28BinaryTreeNode root) {
        if (root==null)
            return false;
        if (root.left == null && root.right == null)
            return true;
        if (root.left == null || root.right == null)
            return false;
        if (root.left.value == root.right.value){
            return isSymmertrical(root.left) && isSymmertrical(root.right);
        }else
            return false;
    }*/

    /**
     * 正确的思路：
     *      前序遍历==中右左遍历
     * */
    public static boolean isSymmertrical (t28BinaryTreeNode root){
        return isSymmertrical(root, root);
    }

    private static boolean isSymmertrical (t28BinaryTreeNode root1, t28BinaryTreeNode root2){
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.value != root2.value)
            return false;
        return isSymmertrical(root1.left, root2.right)
                && isSymmertrical(root1.right, root2.left);
    }

}
