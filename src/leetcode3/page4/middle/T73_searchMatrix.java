package leetcode3.page4.middle;

public class T73_searchMatrix {
    /**
     * 根据矩阵特性搜索
     *
     * 方法一：根据特性搜索
     * 方法二：二分查找
     * */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i=0, j=matrix[0].length-1;
        while(i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high =  m * n - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (matrix[mid/m][mid%m] > target) {
                high = mid - 1;
            } else if (matrix[mid/m][mid%m] < target){
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
