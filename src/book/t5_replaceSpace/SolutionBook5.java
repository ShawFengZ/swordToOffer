package book.t5_replaceSpace;

/**
 * @author zxf
 * @date 2018/8/28 8:39
 */
public class SolutionBook5 {
    /**
     * 替换空格：将空格替换成“%20”
     *      O(n)的解法：
     *          一、利用数组从后往前替换
     *          1. 先遍历一次字符串，统计出要替换的字符的个数
     *          2. 创建临时数组，数组长度为初始字符串字符个数+替换每个字符多出来的字符个数，要替换的个数
     *          3. 从原来的字符串数组，从后往前进行复制，替换到临时数组。两个数组的下标变量分别为：原始数组长度-1，临时数组长度-1
     *          4. 原始字符数组的字符如果不为空格，则把这个字符复制到临时数组的对应位置，数组下标各-1
     *          5. 原始字符数组的字符如果为空格，则把临时数组相对应的位置从后向前填入替换的字符，临时数组下标减少相应的替换的字符数量
     *          6. 循环复制替换，直到初始数组的下标小于0，此时替换完毕，临时数组转换为字符串后返回
     * */
    public String replaceSpace1(char[] string){
        if (string == null)
            return null;
        int originalLength = string.length;
        int spaceCount = 0;
        for (int i=0; i<string.length; i++){
            if (string[i] == ' '){
                spaceCount ++;
            }
        }
        int newLength = originalLength + 2 * spaceCount;
        //创建临时数组
        char[] tempString = new char[newLength];
        //定义两个下标
        int orginalIndex = originalLength - 1;
        int newIndex = newLength -1;
        while (orginalIndex>=0){
            if (string[orginalIndex] == ' '){
                tempString[newIndex]='0';
                tempString[newIndex-1]='2';
                tempString[newIndex-2]='%';
                newIndex -= 3;
            }else {
                tempString[newIndex] = string[orginalIndex];
                newIndex--;
            }
            orginalIndex --;
        }
        //注意这里不要写toString
        return new String(tempString);
    }

    /**
     * 利用StringBuffer实现，时间复杂度O(n)
     *      通过indexOf(String str, int fromIndex)方法和subSequence(int start, int end)联合实现
     * */
    public String replaceSpace2(StringBuffer str){
        if (str == null)
            return null;
        int fromIndex = 0;
        int index = 0;
        StringBuffer temp = new StringBuffer();
        while (index < str.length()){
            //从指定索引开始，返回第一次出现" "的位置
            index = str.indexOf(" ", fromIndex);
            if (index > 0){//找到了有" "，截取前面一段
                temp.append(str.subSequence(fromIndex, index)).append("%20");
                index=index+1;
                fromIndex = index;
            }else {
                //说明没有找到
                temp.append(str.substring(fromIndex, str.length()));
            }
        }
        return temp.toString();
    }

    /**
     * 当字符串修改时，经常使用到的时SpringBuffer和StringBuilder
     *      和String不同的是，StringBuffer和StringBuilder类的对象能够多次被修改，并且不产生新的未使用的对象。
     *      StringBuilder 类在 Java 5 中被提出，它和 StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）。
     *      由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。然而在应用程序要求线程安全的情况
     *      下，则必须使用 StringBuffer 类。
     *  StringBuffer的方法：
     *      1. public StringBuffer append(String s)
     *          将指定的字符串追加到此字符序列。
     *      2. public StringBuffer reverse()
     *          将此字符序列用其反转形式取代。
     *      3. public delete(int start, int end)
     *          移除此序列的子字符串中的字符。
     *      4. public insert(int offset, int i)
     *      5. replace(int start, int end, String str)
     *          使用给定 String 中的字符替换此序列的子字符串中的字符
     *  和String中类似的方法
     *      int indexOf(String str, int fromIndex)
     *          从指定的索引处开始，返回第一次出现的指定子字符串在该字符串中的索引
     *      int lastIndexOf(String str, int fromIndex)
     *          返回 String 对象中子字符串最后出现的位置。
     *      CharSequence subSequence(int start, int end)
     *          返回一个新的字符序列，该字符序列是此序列的子序列
     *      String substring(int start, int end)
     *          返回一个新的 String，它包含此序列当前所包含的字符子序列
     * */
}
