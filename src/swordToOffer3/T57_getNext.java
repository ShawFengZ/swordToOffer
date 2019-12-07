package swordToOffer3;

import sun.reflect.generics.tree.Tree;
import swordToOffer3.utils.ListNode;
import swordToOffer3.utils.TreeLinkNode;

public class T57_getNext {
    /**
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     *
     * 1. 如果该节点有右子树，找到右子树的最左节点
     * 2. 如果该节点没有右子树
     *      如果该节点是父节点的左字节点，就是父节点
     *      如果该节点是父节点的右子节点，就往上找，找到某节点是其父节点的左子节点，返回这个父节点
     *          没找到则返回null
     * */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeLinkNode tmp;
        if (pNode.right != null) {
            tmp = pNode.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            return tmp;
        } else {
            if (pNode.next == null) {
                return null;
            }
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            tmp =pNode.next;
            while (tmp.next != null) {
                if (tmp.next.left == tmp) {
                    return tmp.next;
                }
                tmp = tmp.next;
            }
            return null;
        }

    }
}
