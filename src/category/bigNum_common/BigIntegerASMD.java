package category.bigNum_common;

import java.math.BigInteger;

/**
 * @author zxf
 * @date 2018/9/5 10:38
 */
public class BigIntegerASMD {
    //大整数的加减乘除
    //加
    public String  add(String num1, String num2){
        BigInteger b1 = new BigInteger(num1);
        BigInteger b2 = new BigInteger(num2);

        return b1.add(b2).toString();
    }

    //减
    public String substract(String num1, String num2){
        BigInteger b1 = new BigInteger(num1);
        BigInteger b2 = new BigInteger(num2);

        return b1.subtract(b2).toString();
    }

    //乘
    public String multiply(String num1, String num2){
        BigInteger b1 = new BigInteger(num1);
        BigInteger b2 = new BigInteger(num2);

        return b1.multiply(b2).toString();
    }

    //除
    public String divide(String num1, String num2){
        BigInteger b1 = new BigInteger(num1);
        BigInteger b2 = new BigInteger(num2);

        return b1.divide(b2).toString();
    }

    //除


}
