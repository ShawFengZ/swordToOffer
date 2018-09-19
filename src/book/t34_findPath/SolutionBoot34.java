package book.t34_findPath;

import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * @author zxf
 * @date 2018/9/14 15:52
 */
public class SolutionBoot34 {
    /**
     * 题目描述：
     *      输入一棵二叉树和一个整数，打印出二叉树中节点值之和为输入整数的所有路径。
     *      从树的根节点开始往下一直到叶节点所经过的节点形成一条路径；
     * 思路：
     *      1. 用前序遍历访问某一结点时，将该节点添加到路径上，并累加该节点的值
     *      2. 如果该节点时叶节点，并且路径上节点的值刚好等于输入的整数，则当前路径符合要求，我们将其打印出来
     *      3. 如果当前节点不是叶节点，则继续访问其子节点。
     *      4. 当前节点访问结束后，递归函数会自动返回其父节点
     * */
    public void findPath(t34BinaryTreeNode root, int num){
        if (root == null)
            return;
        Vector<Integer> path = new Vector<>();
        int currentSum = 0;
        findPath(root, num, path, currentSum);
    }

    private void findPath(t34BinaryTreeNode pRoot, int num, Vector<Integer> path, int currentSum){
        currentSum += pRoot.value;
        path.add(pRoot.value);

        //如果是叶节点，并且路径上的节点值等于输入的值，则打印这条路径
        boolean isLeaf = pRoot.left==null && pRoot.right==null;
        if (currentSum == num && isLeaf) {
            System.out.print("A path is found:");
            for (Integer i: path) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        //如果不是叶子节点，则遍历其子节点
        if (pRoot.left != null) {
            findPath(pRoot.left, num, path, currentSum);
        }
        if (pRoot.right != null) {
            findPath(pRoot.right, num, path, currentSum);
        }

        //在返回父节点前要删除路径上的当前节点
        path.remove(path.lastElement());
    }

}
