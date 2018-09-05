package book.t4_2demensionalSearch;

/**
 * @author zxf
 * @date 2018/8/27 21:13
 */
public class Solution4 {

    /**
     * 一个2维数组：
     *      右边的大于左边的，下边的大于上面的，检验数组中是否有某个数字
     *      这种对二维数组操作的方法真的很巧妙
     * */
    public Boolean isInMatrix(int[][] arr, int number){
        Boolean found = false;
        int col = arr[0].length - 1;//列标
        int row = 0;//行标
        while(col>0 && row < arr.length){
            if (number == arr[row][col]){
                found = true;
                break;
            }else if (number < arr[row][col]){
                col --;
            }else {
                row ++;
            }
        }
        return found;
    }
}
