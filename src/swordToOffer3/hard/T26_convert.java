package swordToOffer3.hard;

import swordToOffer3.utils.TreeNode;

public class T26_convert {

    /**
     * 将二叉搜索树转换为排序的双向链表
     *
     * left指向前一个节点，right指向后一个节点
     * */
    private static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        while (p != null && p.right != null) {
            p = p.right;
        }
        if (left != null) {
            pRootOfTree.left = p;
            p.right = pRootOfTree;
        }
        TreeNode right = Convert(pRootOfTree.right);
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        TreeNode convert = Convert(root);
        System.out.println(convert.val);
                //+ "-" + convert.right.val);
    }
}
