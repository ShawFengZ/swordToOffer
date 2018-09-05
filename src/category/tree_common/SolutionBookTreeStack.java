package category.tree_common;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zxf
 * @date 2018/8/28 10:40
 */
public class SolutionBookTreeStack {
    //利用堆栈的方式实现前中后序遍历

    /**
     *前序遍历
     *  中、左、右
     * */
    public void theFirstTraversalStack(Node root){
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while (node != null || stack.size() > 0){//将左孩子全部压栈，如果为空了就退栈，并将右孩子压栈一次
            if (node != null){//压栈前先打印该数值
                BinaryTree.printNode(node);
                stack.push(node);
                node = node.getLeftNode();
            }else {
                node = stack.pop();
                node = node.getRightNode();
            }
        }
    }

    /**
     *中序遍历
     *  左、中、右
     * */
    public void theInOrderTraversal(Node root){
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || stack.size() > 0){
            if (node != null){
                stack.push(node);   //直接压栈
                node = node.getLeftNode();
            }else {
                node = stack.pop(); //出栈并访问
                BinaryTree.printNode(node);
                node = node.getRightNode();
            }
        }
    }

    /**
     * 后续遍历
     *   左、右、中
     * */
    public void thePostOrderTraversalStack(Node root){
        Stack<Node> stack = new Stack<>();
        Stack<Node> output = new Stack<>();//构造一个中间栈来存储逆后序遍历的结果
        Node node = root;
        while (node != null || stack.size()>0){
            if (node != null){
                output.push(node);
                stack.push(node);
                node = node.getRightNode();//先将右子节点压栈，因为输出的时候右子节点在根节点之前
            }else {
                node = stack.pop();
                node = node.getLeftNode();
            }
        }
        while (output.size() > 0){
            BinaryTree.printNode(output.pop());
        }
    }

    /**
     * 层序遍历
     *      从上到下按层遍历
     *      使用队列，也是广度优先搜索
     * */
    public void layerOrderTraversal(Node root){
        Queue<Node> queue = new ArrayDeque<Node>();
        if (root != null){//头节点压入队列
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            Node node = queue.poll();
            BinaryTree.printNode(node);
            if (node.getLeftNode()!=null)
                queue.offer(node.getLeftNode());
            if (node.getRightNode()!=null)
                queue.offer(node.getRightNode());
        }
    }

    /**
     * 队列的使用：
     *      队列是一种特殊的线性表，它只允许在表的前端进行删除删除，在表的后端进行插入操作
     *      添加元素offer()
     *      返回并删除第一个元素poll()
     * */
}
