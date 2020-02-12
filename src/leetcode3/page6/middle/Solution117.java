package leetcode3.page6.middle;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Solution117 {
    private static Node connect(Node root) {
        if (root == null) {
            return root;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else if (root.next != null) {
                Node tmp = root.next;
                while (tmp != null) {
                    if (tmp.left != null) {
                        root.left.next = tmp.left;
                        break;
                    } else if (tmp.right != null) {
                        root.left.next = tmp.right;
                        break;
                    } else {
                        tmp = tmp.next;
                    }
                }
            }
        }
        if (root.right != null) {
            Node tmp = root.next;
            while (tmp != null) {
                if (tmp.left != null) {
                    root.right.next = tmp.left;
                    break;
                } else if (tmp.right != null) {
                    root.right.next = tmp.right;
                    break;
                } else {
                    tmp = tmp.next;
                }
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    public static void main(String[] args) {
        /*Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        root.right.left = new Node(9);
        root.right.right = new Node(1);
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(8);
        root.left.left = new Node(0);
        root.left.left.left = new Node(2);
        root.left.right = new Node(7);
        root.left.right.left = new Node(1);
        root.left.right.right = new Node(0);
        root.left.right.left.left = new Node(7);*/


        System.out.println(1<<2);
        System.out.println(1<<3);
    }
}
