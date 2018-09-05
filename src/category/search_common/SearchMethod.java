package category.search_common;

import java.util.HashMap;

/**
 * @author zxf
 * @date 2018/8/29 15:07
 */
public class SearchMethod {
    /**
     * 查找的一般方法
     *      用一个数组进行测试
     * */

    /**
     * 1. 顺序查找：逐个比较
     *  时间复杂度O(n)
     * */
    public static int OrderSearch(int[] nums, int num){
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == num){
                return i;
            }
        }
        //没找到
        return -1;
    }

    /**
     * 2. 二分法查找
     *  针对排序了的列表
     *  时间复杂度O(log2n)
     * */
    public static int BinarySearch(int[] nums, int num){
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = (low + high)/2;
            int temp = nums[mid];
            if (temp < num){
                low = mid + 1;
            }else if (temp > num){
                high = mid -1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 3. 分块查找法
     *  分块查找的分块：0<可分块<=查找数组元素和
     *  采用HashMap保存区块的极值和起始下标
     *  num 查找的数组
     *  n   分块个数
     *  返回分块起始下标和块的最大值
     * */
    /*public static HashMap<Integer, Integer> spiltBolck(int[] nums, int n){
        HashMap<Integer, Integer> block = new HashMap<>();
        int temp = nums[0];
        for (int i=0; i<nums.length-1; i++){

        }
    }*/

    /**
     * 分块查找的思想
     *      分块查找又称索引顺序查找，它是顺序查找的一种改进方法。
     *      方法描述：
     *          将n个数据元素“按块有序”划分为m块(m<=n)。每一块中的节点不必有序，但块与块之间必须“按块有序”，
     *          即第1块中任一元素的关键字小于第2块中任一元素的关键字，而第2块中任一元素小于第3块中的任意元素，
     *          操作步骤：
     *              1. 先选取各块中的最大关键字构成一个索引表；
     *              2. 对索引表进行二分查找或者顺序查找，确定待查记录在哪一块中；
     *              3. 在已确定的块中用顺序查找进行查找
     * */
}
