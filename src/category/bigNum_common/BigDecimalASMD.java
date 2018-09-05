package category.bigNum_common;

import java.math.BigDecimal;

/**
 * @author zxf
 * @date 2018/9/5 10:41
 */
public class BigDecimalASMD {
    //大浮点数的加减乘除
    //加
    public String add(String num1, String num2){
        BigDecimal b1 = new BigDecimal(num1);
        BigDecimal b2 = new BigDecimal(num2);

        return b1.add(b2).toString();
    }

    //减
    public String subtract(String num1, String num2){
        BigDecimal b1 = new BigDecimal(num1);
        BigDecimal b2 = new BigDecimal(num2);

        return b1.subtract(b2).toString();
    }

    //乘
    public String multiply(String num1, String num2){
        BigDecimal b1 = new BigDecimal(num1);
        BigDecimal b2 = new BigDecimal(num2);

        return b1.multiply(b2).toString();
    }

    //除
    public String divide(String num1, String num2){
        BigDecimal b1 = new BigDecimal(num1);
        BigDecimal b2 = new BigDecimal(num2);

        return b1.divide(b2).toString();
    }

}
