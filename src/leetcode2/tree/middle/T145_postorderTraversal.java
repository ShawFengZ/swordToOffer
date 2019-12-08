package leetcode2.tree.middle;

import leetcode2.utils.TreeNode;
import swordToOffer3.utils.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class T145_postorderTraversal {
    /**
     * 给定一个二叉树，返回它的 后序 遍历。
     *
     * 递归+非递归
     * */
    static List<Integer> list = new ArrayList<>();
    private static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    //非递归解法, 相当于用了一个头插法链表--双端链表
    private static List<Integer> postorderTraversal2(TreeNode root){
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
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
        List<Integer> list = postorderTraversal(root);
        System.out.println(list);
        List<Integer> list2 = postorderTraversal2(root);
        System.out.println(list2);


    }
}
