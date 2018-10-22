package swordToOffer2.t01_FindInMatrix;

/**
 * @author zxf
 * @date 2018/10/19 15:14
 */
public class SolutionS201 {
    /**
     * 二维数组中的查找：
     *      二维数组横向也是升序，纵向也是升序
     * 思路：
     *      1. 先按行确定在哪一行中，使用二分查找。
     *      2. 在那一行中采用二分查找法。
     *      3. 如果存在就能在O(n)的时间复杂度内找到，而不是O(n)
     * 上面的思路有问题：如果找到了一行，但是在那一行中不满足，是否就不往下找了，不对，不能排除这种情况。
     * 思路二：
     *      1. 找满足的行，如果该行满足，就去列里找，如果找到返回true.这种方式的时间复杂度为O(nlogn)
     * 思路三：
     *      官方提供了一种思路：这种思路最好
     *      1. 从右上角往左移动，如果这个数字大于target，说明target不会在这一列中，剔除这一行
     *      2. 如果这个数小于target，则也不可能在这一行中，需要剔除这一行，往下移动。
     *      3. 遇到结果了返回true，结束整个循环。
     * 测试：
     *      1. 空数组
     *      2. 数组中存在该数字
     *      3. 数组中不存在该数字
     * */
     private static boolean Find(int target, int[][] array){
        int row = 0, col=0;
        int rowNum = array.length, colNum = array[0].length;
        int low = 0, high = rowNum;
        int mid = (low + high) / 2;
        while (row < rowNum) {
            if (array[row][0] <= target && array[row][colNum-1] >= target)
                break;
            else
                row++;
        }
        //判断是否找到row
        if (row>=rowNum)
            return false;
        //在这一行中用二分查找法
        low = 0;
        high = colNum-1;
        while (low <= high) {
            mid = (low + high)/2;
            if (array[row][mid] == target) {
                return true;
            } else if (array[row][mid] < target) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return false;
    }

    //这种方式真的很牛逼啊
    private static boolean Find2(int target, int[][] array){
         int row = array.length, col = array[0].length;
         boolean found = false;
         int rowIndex=0, colIndex=col-1;
         while (rowIndex<row && colIndex >= 0) {
             if (array[rowIndex][colIndex] == target) {
                 found = true;
                 break;
             } else if (array[rowIndex][colIndex] > target)
                 colIndex--;
             else
                 rowIndex++;
         }
         return found;
    }

     //测试上面的方法
    public static void main(String[] args) {
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        boolean find = Find2(10, array);
        System.out.println(find);
    }
}
