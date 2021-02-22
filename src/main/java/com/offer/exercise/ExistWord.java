package com.offer.exercise;

/**
 * Created by chenchang on 2021/2/8 15:15.
 *  矩阵中的路径
 */
public class ExistWord {
    public boolean existWord(char[][] board, String word){
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if(dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean res = dfs(board, word,i + 1, j, k + 1) || dfs(board, word,i - 1, j, k + 1)
                || dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = temp;
        return res;
    }
}
