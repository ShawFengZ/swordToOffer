package t2_tihuankongge;

/**
 * @author zxf
 * @date 2018/8/11 13:47
 */
public class Solution {
   /**
    * 这种“”不能过，不知道为什么
    * */
    public String replaceSpace(StringBuffer str){
        if (str==null||str.toString()==""){
            return null;
        }
        int length = str.length();
        int index = 0;
        while(index < length){
            if (str.charAt(index)==' '){
                str.replace(index,index+1, "%20");
                index += 3;
            }else {
                index++;
            }
        }
        return str.toString();
    }

    /**
     * 这种可以通过
     * */
    public String replaceSpace2(StringBuffer str) {
        String sti=str.toString();
        char[] strChar=sti.toCharArray();
        StringBuffer stb=new StringBuffer();
        for(int i=0;i<strChar.length;i++){
            if(strChar[i]==' '){
                stb.append("%20");
            }
            else{
                stb.append(strChar[i]);
            }
        }
        return stb.toString();
    }

    /**
     * 这种方法是最简单的
     * */
    public String replaceSpace3(StringBuffer str){
        return str.toString().replaceAll("\\s", "%20");
    }
}
