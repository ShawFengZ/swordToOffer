package book.t32_printFromTopToBottom;

import java.util.Stack;

/**
 * @author zxf
 * @date 2018/9/14 13:02
 */
public class SolutionBook32_3 {
    /**
     *  题目描述：
     *      请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
     *      第二行按照从右到左的顺序。
     *  思路：
     *      1. 需要两个栈
     *      2. 在打印某一层的时候，将子节点保存到相应的栈中
     *      3. 打印奇数层，先保存左子节点，再保存右子节点到第一个栈
     *      4. 打印偶数层，先保存右子节点，再保存左子节点到第二个栈
     * */
    public static void printFromTopToBottom(T32BinaryTreeNode root){
        if (root == null)
            return;
        Stack<T32BinaryTreeNode> stack1 = new Stack<>();
        Stack<T32BinaryTreeNode> stack2 = new Stack<>();

        stack1.push(root);
        while (stack1.size() > 0 || stack2.size() > 0){
            while (stack1.size() > 0) {
                T32BinaryTreeNode pop = stack1.pop();
                if (pop.left != null) {
                    stack2.push(pop.left);
                }
                if (pop.right != null){
                    stack2.push(pop.right);
                }
                if (stack1.size() == 0){
                    System.out.println(pop.value);
                } else {
                    System.out.print(pop.value+" ");
                }
            }
            while (stack2.size() > 0){
                T32BinaryTreeNode pop = stack2.pop();
                if (pop.right != null){
                    stack1.push(pop.right);
                }
                if (pop.left != null) {
                    stack1.push(pop.left);
                }
                if (stack2.size() == 0){
                    System.out.println(pop.value);
                } else {
                    System.out.print(pop.value+" ");
                }
            }
        }
    }
}
