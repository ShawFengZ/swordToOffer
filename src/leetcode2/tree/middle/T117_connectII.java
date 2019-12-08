package leetcode2.tree.middle;

import leetcode2.utils.Node;

public class T117_connectII {
    /**
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
     * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *
     * 以下解法不能成功。
     * */
    private static Node connect(Node root) {
        if (root == null){
            return root;
        }
        Node left = root.left;
        Node right = root.right;
        while (left != null) {
            if (left.next == null) {
                left.next = right;
            }
            if (left.right != null) {
                left = left.right;
            } else {
                left = left.left;
            }
            if (right != null) {
                if (right.left != null) {
                    right = right.left;
                } else {
                    right = right.right;
                }
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(7);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        Node connect = connect(root);

        System.out.print(connect.next+ " ");
        System.out.print(connect.left.next.val + " ");
        System.out.print(connect.left.left.next.val + " ");
        System.out.println(connect.left.right.next.val);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.left.left = new Node(4);
        root2.right = new Node(3);
        root2.right.right = new Node(5);

        Node connect1 = connect(root2);
        System.out.print(connect1.left.next.val + " ");
        System.out.print(connect1.left.left.next.val + " ");
    }
}
