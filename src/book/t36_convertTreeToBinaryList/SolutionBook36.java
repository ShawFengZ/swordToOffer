package book.t36_convertTreeToBinaryList;

import book.t32_printFromTopToBottom.T32BinaryTreeNode;

import java.util.Stack;

/**
 * @author zxf
 * @date 2018/9/19 16:11
 */
public class SolutionBook36 {
    /**
     * 题目描述
     *      输入一棵二叉搜索树，将该二叉搜索树转化为双端链表。
     *      要求不能创建任何新的节点，只能调整树中节点的指向。
     * 思路：
     *      1. 中序遍历，做两个指针，一个叫pre，一个叫p
     *      2. 如果某个节点只有少于两个的指针，将其左子节点指针指向其前序前节点
     *      3. 如果某个节点只有少于两个的指针，将其左子节点指针指向其前序前节点
     * */

    //递归
    private T36BinaryTreeNode tail = null;
    private T36BinaryTreeNode head = null;

    public T36BinaryTreeNode convert(T36BinaryTreeNode root){
        if (root == null)
            return null;
        convert(root.left);
        if (head == null) {
            head = root;
            tail = root;
        } else {
            root.left = tail;
            tail.right = root;
            tail = root;
        }
        convert(root.right);
        return head;
    }

    //非递归
    public T36BinaryTreeNode convertWithStack(T36BinaryTreeNode root){
        if (root == null)
            return null;
        //如果根节点为null,返回null，否则当前节点指向root
        T36BinaryTreeNode cur = root;
        //pre用于指向当前节点的前一个节点，开始时为null
        T36BinaryTreeNode pre = null;
        Stack<T36BinaryTreeNode> stack = new Stack<T36BinaryTreeNode>();
        while (!stack.isEmpty() || cur != null) {
            //将左子树上的节点入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //如果到了树的最左边，则将栈中的节点出栈
            cur = stack.pop();
            if (pre == null) {
                //刚开始的时候pre==null，将最左边的节点赋值给root。当前节点赋值给pre
                root = cur;
                pre = cur;
            } else {
                //前一个节点的有指针指向cur当前节点，当前节点指向前一个节点pre
                pre.right = cur;
                cur.left = pre;
                pre = cur;
            }
        }
        return root;
    }
}
