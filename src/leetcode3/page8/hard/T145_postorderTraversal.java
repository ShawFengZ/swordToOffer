package leetcode3.page8.hard;

import leetcode2.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T145_postorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        postorderTraversal(root, list);
        return list;
    }

    private static void postorderTraversal(TreeNode root, List<Integer> list){
        if (root == null) {
            return;
        }
        if (root.left != null) {
            postorderTraversal(root.left, list);
        }
        if (root.right != null) {
            postorderTraversal(root.right, list);
        }
        list.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> list = postorderTraversal(root);
        System.out.println(list);
    }
}
