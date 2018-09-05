package book.t3_duplicateNumberInArr;

/**
 * @author zxf
 * @date 2018/8/27 20:45
 */
public class Solution4 {

    /**
     * 不改变数组，找出至少一个重复的数字
     *      脑残的方法：搞一个辅助数组，需要借助的空间为O(n)
     * */
    public Integer getDuplication1(int[] arr){
        Integer[] arrs = new Integer[arr.length];
        for (int i=0; i<arr.length; i++){
            if (arrs[arr[i]]==null){//将数值赋值到它本身所对应的那个索引上面去
                arrs[arr[i]] = arr[i];
            }else {
                return arr[i];//找到了重复的数字
            }
        }
        return null;
    }

    /**
     * 书上更推荐的方法：
     *      避免了O(n)空间的消耗
     * */
    /*public Integer getDuplication2(int[] arr, int length){
        if (arr == null)
            return null;
        if (countNumOfRange(arr, 0, length/2)>(length/2)){
            getDuplication2();
        }
        return null;
    }
*/
    //计算某一个区间的数字出现的次数
    private Integer countNumOfRange(int[] arr, int start, int end){
        int count = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i]<=end && arr[i]>=start){
                count ++;
            }
        }
        return count;
    }
}
