package leetcodeDifficult.t8_StringToInteger;

/**
 * @author zxf
 * @date 2018/10/19 10:57
 */
public class SolutionD08 {
    /**
     * 题目描述：
     *      1. 字符串以空格开头。
     *      2. 找到非空格，如果是+，-和数字，则提取数字直到结束或者再次遇到非数字，则停止
     *      3. 返回得到的数字即可
     *      4. 超过范围的用最大的数代替。
     * 思路：
     *      1. 提取那个数字字符串
     *      2. 将数字字符串转换为数字
     * */
    public static int myAtoi(String str) {
        //去除无关字符
        String num = getValidStr(str);
        if (num == null)
            return 0;
        //判断这个数字是否过界
        if (!isInOfRange(num))
            if (num.charAt(0)=='-')
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        //获取数字
        return getValidNum(num);
    }

    //判断num这个数字是否过界
    private static boolean isInOfRange(String num){
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int getValidNum(String str){
        //判断第一位是不是符号位
        int start = 0; //表第一位是否是符号位
        boolean flag = false;//表第一位正负
        if (str.charAt(0)=='-') {
            start = 1;
            flag = false;
        } else if (str.charAt(0)=='+') {
            start = 1;
            flag = true;
        }
        int index = start;
        while (index < str.length() && str.charAt(index) == '0')
            index++;
        int ans = 0;
        while (index < str.length()) {
            ans = ans * 10 + str.charAt(index)-48;
            index++;
        }
        if (start!=0) {
            if (flag)
                return +ans;
            else
                return -ans;
        } else
            return ans;
    }

    //提取有效的字符串
    private static String getValidStr(String str){
        if (str==null || str.length() == 0)
            return null;
        int start = 0;
        boolean flag = true;//判断是否是有效数字
        while (!(start < str.length() && ((str.charAt(start)<='9' && str.charAt(start)>='0') || (str.charAt(start)=='+' || str.charAt(start)=='-')))) {
            if (start < str.length() && str.charAt(start) == ' ')
                start++;
            else {
                flag = false;
                break;
            }
        }
        if (!flag)
            return null;
        int end = start+1;
        while ((end < str.length() && (str.charAt(end)<='9' && str.charAt(end)>='0'))) {
            end++;
        }
        if (end == start+1 && (str.charAt(start)=='+'||str.charAt(start)=='-'))
            return null;
        return str.substring(start, end);
    }

    public static void main(String[] args) {
        //测试提取字符串
        //System.out.println(getValidStr(" -0456"));
        //System.out.println("456".substring(0,3));
        //System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-"));
        //判断一个String表示的数字是否越界
        //System.out.println(isInOfRange("2147483648"));
    }
}
