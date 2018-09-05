package category.tree_common;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zxf
 * @date 2018/8/29 13:17
 */
public class BinaryTreeSearch {

    /**
     * 广度优先：
     *      BFS(Breadth First Search): 假设每层都是从左往右遍历
     *      1. 先将根节点插入队列，队列中右根节点
     *      2. 根节点弹出，同时将左右子节点插入
     *      3. 弹出左子节点，同时插入左子节点的左右子节点
     *      4. 弹出右子节点，同时插入右子节点的左右子节点
     * */
    public static void printFromTopToBottom(Node root){
        Queue<Node> queue = new LinkedList<>();
        if (root != null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            Node node = queue.poll();
            //打印
            BinaryTree.printNode(node);
            //System.out.println();
            if (node.getLeftNode() != null)
                queue.offer(node.getLeftNode());
            if (node.getRightNode() != null)
                queue.offer(node.getRightNode());
        }
    }

    /**
     * 深度优先搜索：
     *      DFS(Depth First Search).对每一个可能的分支深入到不能再深入为止，而且每个节点只能访问一次
     *      深度优先搜索需要使用栈(STACK), 先进后出
     *      遍历过程：
     *      1. 先将根节点压入栈中
     *      2. 将根节点弹出，同时压入右子节点、左子节点
     *      3. 弹出左子节点，同时压入左子节点的右子节点、左子节点
     * */
    public static void printBinaryTreeDFS(Node root){
        Stack<Node> stack = new Stack<Node>();
        if (root != null){
            stack.push(root);
        }
        Node node = root;
        while (stack.size() > 0){
            if (stack.size()>0){
                node = stack.pop();
                BinaryTree.printNode(node);
            }
            if (node.getRightNode() != null)
                stack.push(node.getRightNode());
            if (node.getLeftNode() != null)
                stack.push(node.getLeftNode());
        }
    }

}
