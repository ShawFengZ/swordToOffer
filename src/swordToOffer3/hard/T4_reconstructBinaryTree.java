package swordToOffer3.hard;


import swordToOffer3.utils.TreeNode;

public class T4_reconstructBinaryTree {

    /**
     * 题目：
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     *
     * 思路：
     * 1. 递归
     * */
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre == null || in == null || pre.length == 0 || pre.length != in.length) {
            return null;
        }
        return reConstructBinaryTree(pre, in, 0, pre.length-1, 0, in.length-1);
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int [] in, int ps, int pe, int is, int ie){
        if (ps > pe || is > ie || pe-ps != ie-is) {
            return null;
        }
        if (ps == pe) {
            return new TreeNode(pre[ps]);
        }
        TreeNode root = new TreeNode(pre[ps]);
        int index = is;
        while (index <=ie && in[index] != pre[ps]) {
            index++;
        }
        int len = index-is;
        root.left = reConstructBinaryTree(pre, in, ps+1, ps+len, is, index-1);
        root.right = reConstructBinaryTree(pre, in, ps+1+len, pe, index+1, ie);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = reConstructBinaryTree(pre, in);

        System.out.println(treeNode.val);
        System.out.println(treeNode.left.val);
        System.out.println(treeNode.left.left.val);
        System.out.println(treeNode.left.left.right.val);
        System.out.println(treeNode.right.val);
        System.out.println(treeNode.right.left.val);
        System.out.println(treeNode.right.right.val);
        System.out.println(treeNode.right.right.left.val);
    }
}
