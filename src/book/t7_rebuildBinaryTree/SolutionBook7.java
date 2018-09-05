package book.t7_rebuildBinaryTree;

/**
 * @author zxf
 * @date 2018/8/30 9:55
 */
public class SolutionBook7 {

    public static Node reConstructBinaryTree(int[] pre, int[] in){
        Node root = reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
        return root;
    }
    //这种写法真的很精妙
    private static Node reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn){
        if (startIn > endIn || startPre > endPre)
            return null;
        Node root = new Node(pre[startPre]);

        for (int i=startIn;i<=endIn;i++){
            if (in[i]==pre[startPre]){
                //构建左子树和右子树
                root.left = reConstructBinaryTree(pre, startPre+1, startPre+i-startIn, in, startIn, i-1);
                root.right =reConstructBinaryTree(pre, i-startIn+startPre+1, endPre, in, i+1, endIn);
                break;
            }
        }
        return root;
    }
}
