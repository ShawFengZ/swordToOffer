package leetcode2.tree.middle;

import leetcode2.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T230_kthSmallest {
    /**
     * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元
     *
     * 逆中序遍历，记录那个数
     * */
    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        getKthSmallest(root, k, list);
        return list.get(k-1);
    }

    private static void getKthSmallest(TreeNode root, int k, List<Integer> list){
        if (root == null) {
            return;
        }
        if (root.left != null) {
            getKthSmallest(root.left, k, list);
        }
        list.add(root.val);
        if (k == list.size()) {
            return;
        }
        if (root.right != null) {
            getKthSmallest(root.right, k, list);
        }
        return;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.left.left.left = new TreeNode(1);

        int kthSmallest = kthSmallest(root, 1);
        int kthSmallest1 = kthSmallest(root1, 3);
        System.out.println(kthSmallest);
        System.out.println(kthSmallest1);

    }
}
