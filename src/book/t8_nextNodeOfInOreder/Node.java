package book.t8_nextNodeOfInOreder;

/**
 * @author zxf
 * @date 2018/8/30 10:37
 */
public class Node {
    private int val;

    public Node father;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }
}
