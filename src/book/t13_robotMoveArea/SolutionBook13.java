package book.t13_robotMoveArea;

/**
 * @author zxf
 * @date 2018/8/31 14:24
 */
public class SolutionBook13 {

    /**
     * 题目描述：
     *      有一个机器人，在一个m行n列的矩阵中运动，不能进入坐标的数位之和大于k的格子
     *      比如k=18, 机器人可以进入matrix[35][37],但不能进入matrix[36][37]
     * 解法：同样基于回溯法
     *      1. 从[0][0]进入，上下左右开始遍历(如果能走通，就不用管，不能走就把flag设为false)
     *      2. 回退到之前那一步继续走
     * 参数说明：
     *      matrix: 矩阵数列，传进来是空，matrix[i][j]=matrix[i*rows+cols]=rows和cols的各位数之和
     *      rows: 行数
     *      cols：列数
     * */
    //时间复杂度O(n^2)，这种不行，因为本题要求的是遍历不重复的格子，所以并不是所有的数值上满足的格子都能访问
    public static int robotMoveAreaNum(int rows, int cols, int k){
        int count = 0;
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (isAccessable(i, j, k))
                    count++;
                else
                    break;
            }
        }
        return count;
    }


    //判断这个坐标位置是否可达
    private static boolean isAccessable(int i, int j, int k){
        int rowsSum = 0;
        int colsSum = 0;
        String strI = Integer.toString(i);
        String strJ = Integer.toString(j);
        for (int si = 0; si<strI.length(); si++)
            rowsSum += strI.charAt(si)-'0';
        for (int sj = 0; sj<strJ.length(); sj++)
            colsSum += strJ.charAt(sj)-'0';
        if (rowsSum + colsSum <= k )
            return true;
        else
            return false;
    }

    /**
     * 回溯法
     * */
    public static int robotMoveAreaNum2(int rows, int cols, int k){
        if (k < 0 || rows <= 0 || cols <= 0)
            return 0;
        //访问标识数组
        boolean[] visited = new boolean[rows * cols];
        //全部设为false
        for (int i = 0; i< rows * cols; i++)
            visited[i] = false;
        return movingCount(k, rows, cols, 0, 0, visited);
    }

    /**
     * 从(0, 0)开始，能到达的位置
     * */
    public static int movingCount(int threshold, int rows, int cols, int row, int col, boolean[] visited){
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)){//可以访问
            visited[row * cols + col] = true;
            count = 1
                    + movingCount(threshold, rows, cols, row-1, col, visited)
                    + movingCount(threshold, rows, cols, row+1, col, visited)
                    + movingCount(threshold, rows, cols, row, col-1, visited)
                    + movingCount(threshold, rows, cols, row, col+1, visited);
        }
        return count;
    }

    /**
     * 判断机器人能否走进坐标为(row, col)的框格，不能走过重复的格子
     * */
    public static boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited){
        if (row >= 0 && row < rows
                && col >=0 && col < cols
                && isAccessable(row, col, threshold)
                && !visited[row * cols + col])//!visited说明之前没有访问过
            return true;
        return false;
    }

}
