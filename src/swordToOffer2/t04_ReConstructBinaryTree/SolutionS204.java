package swordToOffer2.t04_ReConstructBinaryTree;

/**
 * @author zxf
 * @date 2018/10/22 8:50
 */
public class SolutionS204 {
    /**
     * 重建二叉树：
     *      给出先序和中序队列，重建二叉树
     * 思路：
     *      利用递归的方法：
     *      1. 找到根节点，找到左子树和右子树
     *      2. 分别对左子树和右子树进行二叉树的重建
     * */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in){
        return reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre,
                                            int[] in, int startIn, int endIn) {
        if (startIn > endIn || startPre > endPre)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i=startIn; i<endIn; i++){
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre+1, startPre+i-startIn, in, startIn, i-1);
                root.right = reConstructBinaryTree(pre, i-startIn+startPre+1, endPre, in, i+1, endIn);
            }
        }
        return root;
    }
}
