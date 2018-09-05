package t11_numberof1;

/**
 * @author zxf
 * @date 2018/8/11 18:29
 */
public class Solution11 {
    public int NumberOf1(int n) {
        if (n==0){
            return 0;
        }else if (n > 0){
            String nBinary = Integer.toBinaryString(n);
            return countNum(nBinary, '1');
        }else {
            String nBinary = getComplementCode(n);
            return countNum(nBinary, '1');
        }
    }
    //计算一个字符串中某个字符出现的次数
    private int countNum(String str, char s){
        int count = 0;
        for (int i=0; i<str.length(); i++){
            if (str.charAt(i)==s){
                count++;
            }
        }
        return count;
    }

    //计算一个负数的补码
    private String getComplementCode(int a){
        String numStr = "";
        for (int i=0; i<32; i++){
            int t = (a & 0x80000000 >>> i) >>> (31 - i);
            numStr += t;
        }
        return numStr;
    }
}
