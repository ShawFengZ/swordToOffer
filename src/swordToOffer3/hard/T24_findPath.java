package swordToOffer3.hard;

import org.omg.PortableInterceptor.INACTIVE;
import swordToOffer3.utils.TreeNode;

import java.util.ArrayList;
import java.util.function.IntUnaryOperator;

public class T24_findPath {

    /**
     * 二叉树中和为某一值的路径
     *
     * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结
     * 点值的和为输入整数的所有路径。路径定义为从树的根结点
     * 开始往下一直到叶结点所经过的结点形成一条路径。
     * (注意: 在返回值的list中，数组长度大的数组靠前)
     * */
    private static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null || root.val > target) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.val);
        findPath(root, list, res, target-root.val);
        return res;
    }

    private static void findPath(TreeNode root, ArrayList<Integer> list,
                          ArrayList<ArrayList<Integer>> res, int target){
        if (root == null || target < 0) {
            return;
        }
        if (root.left == null && root.right == null && target == 0) {
            res.add(new ArrayList<>(list));
        }
        if (root.left != null) {
            list.add(root.left.val);
            findPath(root.left, list, res, target-root.left.val);
            list.remove(list.size()-1);
        }
        if (root.right != null) {
            list.add(root.right.val);
            findPath(root.right, list, res, target-root.right.val);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(8);

        ArrayList<ArrayList<Integer>> path = findPath(root, 18);
        System.out.println(path);
    }
}
