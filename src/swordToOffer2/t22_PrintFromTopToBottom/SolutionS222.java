package swordToOffer2.t22_PrintFromTopToBottom;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author zxf
 * @date 2018/10/23 11:12
 */
public class SolutionS222 {
    /**
     * 题目描述：
     *      从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * 思路：
     *      1. 树的层序遍历；
     *          a) 递归写法
     *          b) 普通写法
     *      2. 使用队列：一层一层的压栈
     * */
    private static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                list.add(poll.val);
                if (poll.left != null)
                    queue.offer(poll.left);
                if (poll.right != null)
                    queue.offer(poll.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        //root.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(2);
        root.left.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(5);
        ArrayList<Integer> list = PrintFromTopToBottom(root);
        for (Integer e: list)
            System.out.print(e + " ");
    }
}
