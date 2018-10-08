package book.t39_moreThanHalfNum;

/**
 * @author zxf
 * @date 2018/9/20 9:45
 */
public class SolutionBook39 {
    /**
     * 题目描述：
     *      数组中有一个数字出现的次数超过数组长度的一般，请找出这个数字。
     * 思路：
     *      1. 遍历，找出最大值和最小值O(n)
     *      2. 定义一个数组arr[]用来存放每个数字出现的次数O(n)
     *      3. 找到出现次数大于一半的数字
     *      总时间复杂度O(n)，空间复杂度O(n)
     * */
    public int moreThanHalfNum(int[] num){
        if (num==null || num.length <= 1)
            return -1;
        //1. 找出最大值和最小值
        int minNum = num[0], maxNum = num[0];
        for (int i = 0; i< num.length; i++) {
            if (num[i] < minNum){
                minNum = num[i];
            }
            if (num[i] > maxNum){
                maxNum = num[i];
            }
        }
        //2. 定义一个数组记录
        int[] numTemp = new int[maxNum - minNum + 1];
        for (int i = 0; i< num.length; i++) {
            numTemp[num[i] - minNum] ++;
        }
        //3. 找出次数大于一般的数
        for (int i = 0; i < numTemp.length; i++) {
            if (numTemp[i] > num.length/2) {
                return i+minNum;
            }
        }
        //没有，返回-1
        return -1;
    }

    /**
     * 解法二：
     *      1. 在遍历数组的时候保存两个值，一个是数组中的一个数字，一个是次数
     *      2. 当我们遍历下一个数字的时候，如果count=0，就将numTemp设为此数，同时count=1;
     *          否则如果相同则次数加1，如果不同则次数减1
     *      3. 因为某个数字大于一半，那么如果最后有一个数字的次数大于等于1，结果就是它
     * */
    public int moreThanHalfNum2(int[] num) {
        if (num==null || num.length <= 1)
            return -1;
        int numTemp = num[0];
        int count = 1;
        for (int i = 1; i< num.length; i++) {
            if (count == 0) {
                numTemp = num[i];
                count=1;
            } else if (num[i] == numTemp)
                count++;
            else
                count--;
        }
        if (count >= 1)
            return numTemp;
        else
            return -1;
    }

    /**
     * 解法三：基于Partition函数的时间复杂度O(n)的算法
     * 1. 在数组随机选取一个数字，然后调整数组中数字的顺序
     * 2. 比选中数字小的排在左边，比选中数字大的排在右边。
     * 3. 如果选中的这个数字的下标刚好是n/2，那么这个数字就是中位数
     * 4. 如果这个数字的下标大于n/2, 那么中位数在这个数字的左边，我们直接在左边部分查找
     * 5. 如果下标小于n/2，那么中位数在数字的右边，我们直接在右边的数组查找。典型的递归规程
     * */

}
