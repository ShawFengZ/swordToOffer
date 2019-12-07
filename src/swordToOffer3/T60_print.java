package swordToOffer3;

import swordToOffer3.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class T60_print {

    /**
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     *
     * 思路，用两个个队列即可解决问题
     * */
    static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res =  new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Queue<TreeNode> q1 = new ArrayDeque<>();
        Queue<TreeNode> q2 = new ArrayDeque<>();
        q1.offer(pRoot);
        while (!q1.isEmpty() || !q2.isEmpty()) {
            ArrayList<Integer> tmpArrayList1 = new ArrayList<>();
            while (!q1.isEmpty()) {
                TreeNode poll = q1.poll();
                if (poll.left != null) {
                    q2.offer(poll.left);
                }
                if (poll.right != null) {
                    q2.offer(poll.right);
                }
                tmpArrayList1.add(poll.val);
            }
            if (tmpArrayList1.size() > 0) {
                res.add(tmpArrayList1);
            }
            ArrayList<Integer> tmpArrayList2 = new ArrayList<>();
            while (!q2.isEmpty()){
                TreeNode poll = q2.poll();
                if (poll.left != null) {
                    q1.offer(poll.left);
                }
                if (poll.right != null) {
                    q1.offer(poll.right);
                }
                tmpArrayList2.add(poll.val);
            }
            if (tmpArrayList2.size() > 0) {
                res.add(tmpArrayList2);
            }
        }
        return res;
    }
}
