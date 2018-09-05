package category.sort_common;

/**
 * @author zxf
 * @date 2018/8/29 15:51
 */
public class SortUtils {

    /**
     * 输出数组
     * */
    public static void printArr(int[] arr){
        for (int i=0; i<=arr.length-2; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println(arr[arr.length-1]);
    }
}
