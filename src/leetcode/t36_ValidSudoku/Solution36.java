package leetcode.t36_ValidSudoku;

import java.util.HashMap;

/**
 * @author zxf
 * @date 2018/10/18 10:08
 */
public class Solution36 {
    /**
     * 题目描述：
     *      输入一个二维数组，要求(也可以没有数字)
     *      1. 每行得有数字在1-9之间且没有重复；
     *      2. 每列得有数字在1-9之间且没有重复；
     *      3. 每个3*3的小格子得有数字在1-9之间且没有重复
     * */
    public static boolean isValidSudoku(char[][] board) {
        boolean rowFlag = true;
        boolean colFlag = true;
        boolean boxFlag = true;
        HashMap<Integer, Character> mapRow = new HashMap<>();
        HashMap<Integer, Character> mapCol = new HashMap<>();
        HashMap<Integer, Character> mapBox = new HashMap<>();
        //先检查行
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]<='9' && board[i][j]>='0' && !mapRow.containsValue(board[i][j])){
                    mapRow.put(j, board[i][j]);
                } else if (board[i][j]<='9' && board[i][j]>='0' && mapRow.containsValue(board[i][j])) {
                    rowFlag = false;
                    break;
                }
                if (board[j][i]<='9'&& board[j][i]>='0' && !mapCol.containsValue(board[j][i])) {
                    mapCol.put(j, board[j][i]);
                } else if (board[j][i]<='9'&& board[j][i]>='0' && mapCol.containsValue(board[j][i])){
                    colFlag = false;
                    break;
                }
            }
            /*if ( mapRow.size() == 0) {
                rowFlag = false;
            } else
                mapRow.clear();
            if (mapCol.size() == 0) {
                colFlag = false;
            } else
                mapCol.clear();*/
            mapRow.clear();
            mapCol.clear();
            if (!(rowFlag && colFlag))
                break;
        }

        //检查9宫格
        for (int i=0; i<9; i=i+3) {
            for (int j=0;j<9;j=j+3) {
                for (int k = i; k < i+3; k++) {
                    for (int m = j; m < j+3; m++) {
                        if (board[k][m]<='9' && board[k][m]>='0' && !mapBox.containsValue(board[k][m]))
                            mapBox.put(k*10+m, board[k][m]);
                        else if (board[k][m]<='9' && board[k][m]>='0' && mapBox.containsValue(board[k][m])) {
                            boxFlag = false;
                            break;
                        }
                    }
                }
                /*if (mapBox.size() == 0) {
                    boxFlag = false;
                    break;
                } else
                    mapBox.clear();*/
                mapBox.clear();
                if (!boxFlag)
                    break;
            }
        }

        return rowFlag && colFlag && boxFlag;
    }
}
