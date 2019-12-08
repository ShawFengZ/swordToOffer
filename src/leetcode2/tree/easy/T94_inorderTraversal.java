package leetcode2.tree.easy;

import leetcode2.utils.TreeNode;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T94_inorderTraversal {
    /**
     * 给定一个二叉树，返回它的中序 遍历。
     *
     * 递归很简单
     *
     * 非递归，借助栈
     * */
    //递归
    static ArrayList<Integer> list = new ArrayList<>();
    private static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    //非递归写法
    private static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                res.add(p.val);
                p = p.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(6);
        List<Integer> list = inorderTraversal(root);

        List<Integer> list1 = inorderTraversal2(root);
        System.out.println(list);
        System.out.println(list1);
    }
}
