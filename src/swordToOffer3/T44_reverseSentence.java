package swordToOffer3;

public class T44_reverseSentence {
    /**
     * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
     * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他
     * 向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
     * 后来才意识到，这家伙原来把句子单词的顺序翻转了，
     * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单
     * 词顺序可不在行，你能帮助他么？
     * */
    public static String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        String[] strs = str.split(" ");
        if (strs.length == 0) {
            return str;
        }
        strs = reverseWordsArray(strs);
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<strs.length-1; i++) {
            sb.append(strs[i]);
            sb.append(" ");
        }
        sb.append(strs[strs.length-1]);
        return sb.toString();
    }

    private static String[] reverseWordsArray(String[] strs){
        if (strs == null || strs.length == 0) {
            return strs;
        }
        for (int i=0; i<strs.length/2; i++) {
            String tmp = strs[i];
            strs[i] = strs[strs.length-1-i];
            strs[strs.length-1-i] = tmp;
        }
        return strs;
    }
}
