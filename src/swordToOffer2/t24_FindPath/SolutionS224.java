package swordToOffer2.t24_FindPath;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author zxf
 * @date 2018/10/24 10:56
 */
public class SolutionS224 {
    /**
     * 题目描述：
     *      输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     *      路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返
     *      回值的list中，数组长度大的数组靠前)
     * 思路：
     *      1. 深度优先搜索的变形
     *      2. 一边深度优先搜索，一边计算，如果大于target就退回上一步
     * */
    private static ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return null;
        Stack<Integer> path = new Stack<>();
        findPath(root, target, path,0);
        return arrayLists;
    }

    /**
     * 如果sum=target,且root为叶子节点，返回list
     * */
    private static void findPath(TreeNode root, int target, Stack<Integer> path, int sum){
        if (root == null)
            return;
        //判断是否是叶子节点
        if (root.left == null && root.right == null) {
            if (root.val + sum == target) { //添加当前路径
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int val: path)
                    list.add(val);
                list.add(root.val);
                arrayLists.add(list);
            }
        } else {
            //不是叶子节点的时候
            path.push(root.val);
            findPath(root.left, target, path, sum+root.val);
            findPath(root.right, target, path, sum+root.val);
            //返回父节点前，在路径上删除当前节点的值
            path.pop();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ArrayList<ArrayList<Integer>> arrayLists = FindPath(root, 8);
        for (ArrayList<Integer> list: arrayLists) {
            System.out.println(list);
        }
    }
}
