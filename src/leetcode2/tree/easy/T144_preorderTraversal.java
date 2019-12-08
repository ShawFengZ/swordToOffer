package leetcode2.tree.easy;

import leetcode2.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T144_preorderTraversal {
    /**
     * 二叉树的前序遍历
     *
     * 1. 递归
     * 2. 非递归(重点)
     * */
    static List<Integer> list = new ArrayList<>();
    private static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }

    //非递归
    private static List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p!= null) {
                res.add(p.val);
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (p.right != null) {
                    p = p.right;
                } else {
                    p = null;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<Integer> list = preorderTraversal(root);
        List<Integer> list1 = preorderTraversal2(root);
        System.out.println(list1);
        System.out.println(list);
    }
}
