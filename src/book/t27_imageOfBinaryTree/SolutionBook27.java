package book.t27_imageOfBinaryTree;

/**
 * @author zxf
 * @date 2018/9/10 16:50
 */
public class SolutionBook27 {

    /**
     * 题目描述：
     *      请完成一个函数，输入一棵二叉树，该函数输出它的镜像
     * 思路：
     *      递归交换非叶子节点的左子树和右子树
     * */
    public t27BinaryTreeNode mirrorRecurisively(t27BinaryTreeNode root){
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root;
        t27BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //这里需要判断
        if (root.left != null)
            mirrorRecurisively(root.left);
        if (root.right != null)
            mirrorRecurisively(root.right);
        return root;
    }
}
