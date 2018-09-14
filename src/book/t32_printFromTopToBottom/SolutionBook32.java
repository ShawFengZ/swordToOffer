package book.t32_printFromTopToBottom;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author zxf
 * @date 2018/9/13 15:58
 */
public class SolutionBook32 {
    /**
     * 题目描述：
     *      从上到下打印二叉树的每个节点，同一层的节点按从左到右的顺序打印
     * 思路：
     *      广度优先搜索，用队列即可(先进先出)
     * */
    public static void printFromTopToBottom(T32BinaryTreeNode root){
        if (root == null){
            return;
        }
        Queue<T32BinaryTreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (queue.size()!=0){
            root = queue.poll();
            if (root.left != null){
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
            System.out.print(root.value + " ");
        }
    }
}
