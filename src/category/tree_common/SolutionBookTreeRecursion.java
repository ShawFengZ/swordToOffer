package category.tree_common;

/**
 * @author zxf
 * @date 2018/8/28 10:25
 */
public class SolutionBookTreeRecursion {
    //递归的方式实现二叉树的前序、中序、后序遍历

    /**
     * 前序：
     *     中、左、右
     * */
    public void theFirstTraversal(Node root){
        if (root == null)
            return;
        BinaryTree.printNode(root);
        if (root.getLeftNode() != null){
            theFirstTraversal(root.getLeftNode());
        }
        if (root.getRightNode() != null){
            theFirstTraversal(root.getRightNode());
        }
    }

    /**
     * 中序：
     *      左、中、右
     * */
    public void theInOrderTraversal(Node root){
        if (root == null)
            return;
        if (root.getLeftNode() != null){
            theInOrderTraversal(root.getLeftNode());
        }
        BinaryTree.printNode(root);
        if (root.getRightNode() != null){
            theInOrderTraversal(root.getRightNode());
        }
    }

    /**
     * 后序
     *      左、右、中
     * */
    public void thePostOrderTraversal(Node root){
        if (root == null)
            return;
        if (root.getLeftNode() != null){
            thePostOrderTraversal(root.getLeftNode());
        }
        if (root.getRightNode() != null)
            thePostOrderTraversal(root.getRightNode());
        BinaryTree.printNode(root);
    }


}
