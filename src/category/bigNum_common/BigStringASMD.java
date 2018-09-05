package category.bigNum_common;

/**
 * @author zxf
 * @date 2018/9/5 11:04
 */
public class BigStringASMD {
    //将string转化为指定的长度
    public static String castSame(String input, int len){
        if (input.length() > len){
            return null;
        }
        StringBuilder result = new StringBuilder(input);
        int subLength = len - input.length();
        for (int i = 0; i < subLength; i++){
            //在0的位置插入0，相当于在前面补0
            result.insert(0, 0);
        }
        return result.toString();
    }

    //去掉前面无效的0(参数为整数)
    public static String removeZero(String input){
        int length = input.length();
        int i=0;
        for (; i<length; i++){
            //parseInt里面的参数应该是字符串
            int current = Integer.parseInt(input.charAt(i)+"");
            if (current !=0 )
                break;
        }
        if (i == length)
            return "0";
        else
            return input.substring(i);
    }

    //判断两个参数谁更小(输入的两个数为整数)
    public static boolean isSmall(String num1, String num2){
        if (num1.length() < num2.length())
            return true;
        else if (num1.length() > num2.length())
            return false;

        //两个数的总位数相同
        int index = 0;
        while (index < num1.length()){
            int num1Temp = Integer.parseInt(num1.charAt(index) + "");
            int num2Temp = Integer.parseInt(num2.charAt(index) + "");
            if (num1Temp < num2Temp)
                return true;
            else if (num1Temp > num2Temp)
                return false;
            index++;
        }
        return false;
    }

    //使用String模拟大数减法
    public static String sub(String num1, String num2){
        // 标识结果是否为负
        boolean isNeg = false;
        StringBuilder result = new StringBuilder();
        //处理负号
        if (num1.contains("-") && !num2.contains("-")){
            num1 = num1.replace("-", "");
            result.append(add(num1, num2));
            return "-" + result.toString();
        } else if (num1.contains("-") && num2.contains("-")){
            num1 = num1.replace("-", "");
            num2 = num2.replace("-", "");
            return sub(num2, num1);
        } else if (!num1.contains("-") && num2.contains("-")){
            return add(num1, num2);
        }

        //判断两个数谁更大，用大的减小的
        if (isSmall(num1, num2)){
            String temp = num1;
            num1 = num2;
            num2 = temp;
            isNeg = true;
        }

        //两个正数相减
        int index = num1.length() - 1;
        int res = 0;
        // 借位标识
        int borrows = 0;
        while (index >= 0){
            int num1Int = Integer.parseInt(num1.charAt(index) + "");
            int num2Int = Integer.parseInt(num2.charAt(index) + "");
            if ((num1Int - borrows) < num2Int){
                res = 10 + num1Int - borrows - num2Int;
                borrows = 1;
            } else {
                res = num1Int - borrows - num2Int;
                borrows = 0;
            }
            result.append(res);
            index --;
        }

        //去掉前面无效的0
        String resultStr = "";
        if (isNeg) {
            resultStr = removeZero(result.reverse().toString());
            resultStr = "-" + resultStr;
        } else {
            resultStr = removeZero(result.reverse().toString());
        }
        return resultStr;
    }

    //使用String模拟大数加法
    public static String add(String num1, String num2){
        StringBuilder result = new StringBuilder();
        //标识结果是否为负
        boolean isNeg = false;
        //处理符号
        if (num1.contains("-") && num2.contains("-")){
            num1 = num1.replace("-","");
            num2 = num2.replace("-","");
            isNeg = true;
        } else if (num1.contains("-") && !num2.contains("-")){
            num1 = num1.replace("-","");
            return sub(num2, num1);
        } else if (!num1.contains("-") && num2.contains("-")){
            num2 = num2.replace("-", "");
            return sub(num1, num2);
        }
        //将两个加数处理成长度相同的的字符串，长度不够，使用0填充
        if (num1.length() > num2.length()){
            num2 = castSame(num2, num1.length());
        }else if (num1.length() < num2.length()){
            num1 = castSame(num1, num2.length());
        }

        //此时相当于两个长度相等的整数相加
        int length = num1.length();
        int index = length - 1;
        //进位标识
        int add = 0;
        //当前位的结果
        int res = 0;
        int sum = 0;
        int num1Int;
        int num2Int;

        while (index >= 0){
            num1Int = Integer.parseInt(num1.charAt(index) + "");
            num2Int = Integer.parseInt(num2.charAt(index) + "");
            sum = num1Int + num2Int + add;
            add = sum / 10;
            res = sum % 10;
            result.append(res);
            index--;
        }

        //处理最后一个进位
        if (add == 1){
            result.append(1);
        }
        String resultStr = removeZero(result.reverse().toString());
        if (isNeg)
            resultStr = "-" + resultStr;
        return resultStr;
    }

    //使用String模拟大数乘法
    public static String multi(String num1, String num2){
        //正负标记号
        boolean isNeg = false;
        //判断符号
        if (num1.contains("-") && !num2.contains("-")){
            isNeg = true;
            num1 = num1.replace("-", "");
        } else if (!num1.contains("-") && num2.contains("-")){
            isNeg = true;
            num2 = num2.replace("-", "");
        } else if (num1.contains("-") && num2.contains("-")){
            num1 = num1.replace("-", "");
            num2 = num2.replace("-", "");
        }
        //计算两个正数的乘法
        if (isSmall(num1, num2)){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        StringBuilder sumBuilder = new StringBuilder();
        String sum = "0";
        String sumTemp = "0";
        int index = 0;
        for (int i = num2.length()-1; i >= 0; i--){
            int current = num2.charAt(i) - '0';
            sumTemp = "0";
            // 循环做n次加法，就相当于乘上n
            for (int j=0; j<current; j++){
                sumTemp = add(num1, sumTemp);
            }
            sumBuilder = new StringBuilder(sumTemp);
            //中间结果向左移动几位
            for (int k=0; k<index; k++){
                sumBuilder.append("0");
            }
            index ++;
            sum += add(sum, sumBuilder.toString());
        }
        if (isNeg) {
            return "-" + sum;
        } else {
            return sum;
        }
    }
}
