package book.t17_printToLargestN;

/**
 * @author zxf
 * @date 2018/9/5 10:12
 */
public class SolutionBook17 {

    /**
     * 题目描述：
     *      输入数字n, 按顺序打印出从1到最大的n位十进制数。
     *      比如输入3，则打印出1，2，3,...,999
     * 思路：
     *      没有说不考虑大数，因此就是要考虑大数，那么得用字符串来打印了
     * */
    /**
     * 第一种解法
     * */
    public void print1ToLargestNDigits(int n){
        if (n <= 0){
            System.out.println("输入的n没有意义！");
            return;
        }
        //声明字符数组，用来存放一个大数
        char[] number = new char[n];
        for (int i = 0; i < number.length; ++i){//放字符0进行初始化
            number[i] = '0';
        }
        while (!incrementNumber(number)){//如果大数自加，直到自溢退出
            printNumber(number);
        }
    }

    //自加
    private boolean incrementNumber(char[] number){
        boolean isOverflow = false;//判断是否溢出
        int nTakeOver = 0;//判断是否进位
        int nLength = number.length;
        for (int i = nLength - 1; i >= 0; --i){
            int nSum = number[i] - '0' + nTakeOver;
            if (i == nLength - 1){
                ++ nSum;
            }
            if (nSum >= 10){
                if(i == 0){
                    isOverflow = true;
                }else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) ('0' + nSum);
                }
            } else {
                number[i] = (char) (nSum + '0');
                break;
            }
        }
        return isOverflow;
    }
    //打印数字
    private void printNumber(char[] number){
        boolean isBeginning0 = true;//要排除前面的0
        int nLength = number.length;
        for (int i=0; i < nLength; ++i){
            if (isBeginning0 && number[i] != '0'){
                isBeginning0 = false;
            }
            if (!isBeginning0){
                System.out.print(number[i]);
            }
        }
        //打印空格
        System.out.println();
    }
}
