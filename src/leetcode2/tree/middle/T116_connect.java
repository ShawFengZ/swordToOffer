package leetcode2.tree.middle;

import leetcode2.utils.Node;
import leetcode2.utils.TreeNode;

public class T116_connect {
    /**
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
     * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *
     * 思路：
     *  1. 将两棵树劈开，连接起来；
     *  2. 递归处理每个节点；
     * */
    private static Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node left = root.left;
        Node right = root.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }



    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        Node connect = connect(root);

        System.out.println(connect.next);
        System.out.println(connect.left.next.val);
        System.out.println(connect.left.left.next.val);
        System.out.println(connect.left.right.next.val);
        System.out.println(connect.right.left.next.val);
    }

}
