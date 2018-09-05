package book.t12_pathInMatrix;

/**
 * @author zxf
 * @date 2018/8/31 13:37
 */
public class SolutionBook12 {

    /**
     * 寻找矩阵中的路径
     *      matrix: 矩阵字符串
     *      rows: 矩阵行
     *      cols: 矩阵列
     *      str: 字符串路径
     * */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        boolean[] flag = new boolean[matrix.length];//matrix.length=rows
        for (int i=0; i< rows; i++){//按行遍历矩阵中的每个元素
            for (int j=0; j<cols; j++){
                if (helper(matrix, rows, cols, i, j, str, 0, flag))//遍历找到str的第一个字符的位置，以此为起点
                    return true;
            }
        }
        return false;
    }

    /**
     * 1. 矩阵是用字符串表示的，因此matrix[i][j]==matrix[i*cols + rows]
     * */
    private static boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, boolean[] flag){
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j>= cols || matrix[index] != str[k] || flag[index])
            return false;
        if (k == str.length - 1)
            return true;
        flag[index] = true;
        if (helper(matrix, rows, cols, i-1, j, str, k+1, flag)//找左边
                ||helper(matrix, rows, cols, i+1, j, str, k+1, flag)//找右边
                ||helper(matrix, rows, cols, i, j-1, str, k+1, flag)//找上边
                ||helper(matrix, rows, cols, i, j+1, str, k+1, flag)){//找下边
            return true;
        }
        //假如没有找到，flag[index]=false，基于此路的就不用再找了,就退回到前一格子重新开始找
        //比如说，向上找，没有找到，就不要继续递归下去了，到下边接着找
        flag[index] = false;
        return false;
    }
}
