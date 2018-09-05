package category.sort_common;

import java.util.Arrays;

/**
 * @author zxf
 * @date 2018/8/29 15:41
 */
public class SortMethod {

    /**
     * 这里列举十大经典排序方法
     * */

    /**
     * 一、冒泡排序
     *      步骤：
     *      1. 比较相邻的元素。如果第一个比第二个大，就交换它们。
     *      2. 遍历数组，重复以上操作。一次遍历之后肯定会将最大的那个数排到最后面。
     *      3. 再次遍历数组的0—n-2位，重复那个比较的操作。
     *      ... ...
     *      时间复杂度：O(n^2)(最坏、平均)
     *                  O(n) 最好
     *      空间复杂度：O(1)
     * */
    public static int[] bubbleSort(int[] arr){
        int len = arr.length;
        for (int i=0; i<len-1; i++){//相当于将最大的冒泡到最后
            for (int j=0; j<len-1-i; j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 二、选择排序
     *      工作原理：首先在未排序序列中找到最小(大)元素，存放到序列起始位置，然后，再从剩余未排序元素中继续寻找最小(大)元素
     *      放到已排序序列的序尾，直到所有元素均排序完毕。
     *      时间复杂度：O(n^2)(最好、最坏、平均)
     *      空间复杂度：O(1)
     * */
    public static int[] selectionSort(int[] arr){
        for (int i=0; i<arr.length-1; i++){
            int minNum=arr[i];//记录每一次遍历得到的那个最小值
            int minIndex = i;
            for (int j=i+1; j<arr.length-1; j++){
                if (arr[j]<minNum){//找到最小的值和索引
                    minNum = arr[j];
                    minIndex = j;
                }
            }
            //交换最小值和最前面的那个值
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    /**
     * 三、插入排序
     *      工作原理：通过构建有序序列，对于未排序的数据，在已排序的序列中从后向前扫描，找到相应位置并插入。
     *      算法步骤：
     *          1. 从第一个元素开始，该元素被视为已排序
     *          2. 取出下一个元素在已排序的元素序列中从前往后扫描
     *          3. 如果该元素(已排序)大于新元素，将该元素移到下一位置
     *          4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     *          5. 将新元素插入到该位置后；
     *          6. 重复步骤2—5
     *      时间复杂度：O(n^2)(最坏、平均)
     *                  O(n)(最好)
     *      空间复杂度：O(1)
     * */
     public static int[] insertionSort(int[] arr){
         for (int i=1; i<arr.length; i++){
             int currentNum = arr[i];
             int preIndex = i-1;
             while (arr[preIndex]>currentNum && preIndex >= 0){
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
             }
             arr[preIndex+1] = currentNum;
         }
         return arr;
     }

     /**
      * 四、希尔排序：
      *     1959年Shell发明，第一个突破O(n^2)的排序算法，是简单插入排序的改进版。
      *     和插入排序的不同在于，它会优先比较距离较远的元素，希尔排序又叫缩小增
      *     量排序
      *     算法描述：先将整个待排序的记录序列分割成若干子序列分别进行直接插入排序
      *         1. 选择一个增量序列t1, t2, ..., tk
      *         2. 按增量序列个数k，对序列进行k趟排序
      *         3. 每趟排序，根据对应的增量ti，将带排序列分割成若干长度为m的子序列，分别对各子表进行插入排序。
      *         看代码，理清楚思路。
      *     时间复杂度：O(n^(1.3))最优
      *                 O(n^2)
      *     空间复杂度：O(1)
      * */
     public static int[] shellSort(int[] arr){
         if (arr==null || arr.length ==0)
             return null;
         //设置增量
         int incrementNum = arr.length / 2;
         while (incrementNum >= 1){
             for (int i=0; i<arr.length; i++){
                 //进行插入排序
                 for (int j = i; j < arr.length-incrementNum; j = j+incrementNum){
                     if (arr[j]>arr[j+incrementNum]){//数值交换
                         int temp = arr[j];
                         arr[j] = arr[j+incrementNum];
                         arr[j+incrementNum] = temp;
                     }
                 }
             }
             //设置新的增量
             incrementNum = incrementNum / 2;
         }
         return arr;
     }

     /**
      * 五、归并排序
      *     归并排序是分治法的一个非常典型的应用。将已有序的子列合并，得到完全有序的序列；
      *     思路：
      *         1. 将长度为n的输入序列分为两个长度为n/2的子序列
      *         2. 对两个自学列分别采用归并排序；
      *         3. 将两个排序好的子序列归并为一个最终的牌序序列
      *     时间复杂度：O(nlog2n)平均、O(n^2)最坏，O(n)最好， 稳定
      *     空间复杂度：O(n)
      * */
     public static int[] mergeSort(int[] arr){
         if (arr == null || arr.length == 0)
             return null;
         if (arr.length < 2)
             return arr;
         int middle = arr.length/2;
         int[] left = Arrays.copyOfRange(arr, 0, middle);
         int[] right = Arrays.copyOfRange(arr, middle, arr.length);
         return merge(mergeSort(left), mergeSort(right));
     }
     public static int[] merge(int[] arr1, int[] arr2){
         int[] res = new int[arr1.length + arr2.length];//创建一个长度刚好的数组
         int index1=0, index2=0;
         int index = 0;//结果数组的下标
         while (index1 < arr1.length && index2 < arr2.length){
             if (arr1[index1] < arr2[index2]){
                 res[index++] = arr1[index1++];
             }else {
                 res[index++] = arr2[index2++];
             }
         }
         if (index1 < arr1.length){//第一个数组还没完
             for (int i=index1; i < arr1.length; i++)
                 res[index++] = arr1[i];
         }
         if (index2 < arr2.length){//第一个数组还没完
             for (int i=index2; i < arr2.length; i++)
                 res[index++] = arr2[i];
         }
         return res;
     }

    /**
     * 六、快速排序(现在是有问题的，详情见代码)
     *      基本思想：通过一趟排序将待排记录分割成独立的两部分，其中一部分的关键字均比另一部分小，
     *      则可对这两个部分分别进行相同的操作，达到排序的目的
     *      思路：
     *          1. 从数列中挑出一个元素，称为基准(pivot)
     *          2. 重新排序数列，所有元素比基准值小的放到基准值之前，大的放到后面(相同的数放到一起)。
     *              在这个分区退出之后，该基准值就处于队列的中间位置。这个称为分区操作。
     *          3. 递归的把小于基准值的和大于基准值的子数列进行排序。
     *      时间复杂度：O(nlog2n)最好、平均，O(n^2)最坏
     *      空间复杂度：O(nlog2n)
     *      稳定性：不稳定
     * */
    public static int[] quickSort(int[] arr, int low, int high){
        if (low < high) {
            int middle = getMiddle(arr, low, high);
            //没有考虑一个问题，就是获取到的middle刚好为0或者为arr.length-1怎么办
            quickSort(arr, low, middle - 1);
            quickSort(arr, middle+1, high);
        }
        return arr;
    }
    //分区操作
    private static int getMiddle(int[] arr, int low, int high){
        //固定切分方式
        int temp = arr[low];//数组的第一个作为中轴
        while (low < high){
            while (low < high && arr[high] >= temp){
                //如果arr[high]>temp会一直在这个循环里，high一直减，直到这个条件不成立
                high --;
            }
            arr[low] = arr[high];//比中轴小的移到低端
            while (low < high && arr[low] <= temp){
                low ++;
            }
            arr[high] = arr[low];//比中轴大的移到高端
        }
        arr[low] = temp;//中轴记录到尾
        return low;
    }

    /**
     * 七 堆排序
     * */

    /**
     *八、计数排序
     *    计数排序不是基于比较的排序算法，其核心在于将输入的数据转化为键值存储在额外开辟的数组空间。
     *    作为一种线性时间复杂度的排序方式，计数排序要求输入的数据是有确定范围的整数。
     *    步骤：
     *      1. 找出待排序的数组中的最大和最小元素
     *      2. 统计数组中每个数值为i的元素出现的次数，存到数组C的第i项
     *      3. 对所有的计数累加(从C的第一个元素开始，每一项和前一项相加)
     *      4. 反向填充目标数组：将每个元素i放到数组的C(i)项，存放一个元素就将C(i)-1
     * */
    public static int[] countingSort(int[] arr){
        int max = getMaxAndMin(arr);
        int[] b = new int[arr.length];//目标数组
        int[] c = new int[max + 1];//中间数组

        for (int i=0; i<arr.length; i++)
            c[arr[i]] += 1;

        for (int i=1; i<c.length; i++){
            c[i] += c[i-1];//方便下标累加
        }

        //这一步不是很好理解
        for (int i=arr.length; i>=0; i--){
            b[c[arr[i]] - 1] = arr[i];
            c[arr[i]]--;
        }
        return b;
    }
    //获取一个数组中的最大值
    private static int getMaxAndMin(int[] arr){
        int max = arr[0];
        for (int i=0; i<arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

}
