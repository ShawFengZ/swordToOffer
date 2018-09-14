package book.t32_printFromTopToBottom;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author zxf
 * @date 2018/9/13 16:24
 */
public class SolutionBook32_2 {
    /**
     * 题目描述：
     *      从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，
     *      每一层打印到一行。
     * 思路：
     *      1. 依然是树的广度优先搜索，用队列
     *      2. 增加两个变量，一个表示当前层还没打印的节点数remainNum,
     *         一个表示下一层节点数nextLevelNum
     * */
    public static void printFromTopToBottomInlevel(T32BinaryTreeNode root){
        if (root == null){
            return;
        }
        Queue<T32BinaryTreeNode> queue = new ArrayDeque<>();
        int remainNum = 0;
        int nextLevelNum = 0;
        queue.offer(root);
        remainNum = 1;
        while (queue.size() > 0){
            root = queue.poll();
            if (root.left != null){
                queue.offer(root.left);
                nextLevelNum++;
            }
            if (root.right != null){
                queue.offer(root.right);
                nextLevelNum++;
            }
            if (remainNum == 1){
                System.out.println(root.value);
                remainNum = nextLevelNum;
                nextLevelNum=0;
            } else {
                System.out.print(root.value + " ");
                remainNum--;
            }
            //System.out.print(root.value + " ");
        }
    }
}
