package dpProblems.t02GetApples;

/**
 * @author zxf
 * @date 2018/12/7 10:22
 */
public class DpSolution02 {
    /**
     * 题目描述：一个矩形区域被划分为N*M个小矩形格子，在格子[i, j]上有A[i][j]个苹果。
     *          现在从左上角的格子(1,1)出发，要求每次只能向右走一步或向下走一步，最
     *          后到达(N,M)，每经过一个格子就把其中的苹果全部拿走。请找出能拿到最多
     *          苹果数的路线。
     * 解题思路:
     *          1. M[i][j]表示到达(i, j)所能得到的最多的苹果数
     *          2. M[i][j]=max(M[i-1][j], M[i][j-1])+A[i][j]
     *          3. 特殊情况M[1][1]=A[1][1], 当i=1，j!=1时(在第一行)，M[i][j]=M[i][j-1]+A[i][j]
     *                                      当i!=1, j=1时(在第一列)，M[i][j]=M[i-1][j]+A[i][j]
     *          时间复杂度为O(n^2)
     * */
    public static int[][] getMostApples(int[][] A){
        if (A==null || A.length==0 || A[0].length==0)
            return null;
        int n = A.length;
        int m = A[0].length;
        int[][] M = new int[n][m];
        M[0][0] = A[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i != 0 && j != 0)
                    M[i][j] = Math.max(M[i][j-1], M[i-1][j]) + A[i][j];
                else if ( i == 0 && j != 0)
                    M[i][j] = M[i][j-1] + A[i][j];
                else if (i != 0 && j == 0)
                    M[i][j] = M[i-1][j] + A[i][j];
                else if (i == 0 && j ==0)
                    M[i][j] = A[i][j];
            }
        }
        return M;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 2, 8}, {3, 3, 2}, {4, 1, 1}};
        int[][] mostApples = getMostApples(A);
        for (int i = 0; i < mostApples.length; i++) {
            for (int j = 0; j < mostApples[0].length; j++)
                System.out.print(mostApples[i][j] + " ");
            System.out.println();
        }
    }
}
