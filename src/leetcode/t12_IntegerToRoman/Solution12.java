package leetcode.t12_IntegerToRoman;

/**
 * @author zxf
 * @date 2018/10/8 16:52
 */
public class Solution12 {
    /**
     * 将一个Integer转换为罗马字母表示
     * I-1
     * V-5
     * X-10
     * L-50
     * C-100
     * D-500
     * M-1000
     *
     * 思路：
     *      1. 分别求出各个位数的个数
     * */
    public static String intToRoman(int num){
        if (num == 0)
            return null;
        String ans = "";
        int numTh=0, numFH=0, numH=0, numFT=0, numT=0, numF=0, numO=0;
        numTh = num/1000;
        num = num % 1000;
        for (int i = 0; i< numTh; i++) {
            ans += "M";
        }
        numFH = num / 500;
        num = num % 500;
        for (int i = 0; i< numFH; i++) {
            ans += "D";
        }
        numH = num / 100;
        num = num % 100;
        for (int i = 0; i< numH; i++) {
            ans += "C";
        }
        numFT = num / 50;
        num = num %  50;
        for (int i = 0; i< numFT; i++) {
            ans += "L";
        }
        numT = num / 10;
        num = num % 10;
        for (int i = 0; i< numT; i++) {
            ans += "X";
        }
        numF = num / 5;
        num = num % 5;
        for (int i = 0; i< numF; i++) {
            ans += "V";
        }
        numO = num;
        for (int i = 0; i< numO; i++) {
            ans += "I";
        }

        return ans;
    }
}
