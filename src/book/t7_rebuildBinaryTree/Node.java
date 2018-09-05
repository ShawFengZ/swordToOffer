package book.t7_rebuildBinaryTree;

/**
 * @author zxf
 * @date 2018/8/30 9:54
 */
public class Node {
    private int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }

    public int getVal(){
        return this.val;
    }
}
