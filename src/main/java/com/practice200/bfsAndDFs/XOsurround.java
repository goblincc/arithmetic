package com.practice200.bfsAndDFs;

/**
 *  130 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *  方法：
 *  1、深度优先遍历矩阵边界上的'O'，找到与之连接的'O', 将其变为'#'
 *  2、剩下的'O'就是被X包围的， 将其变为X， 再将#变为O
 */
public class XOsurround {

    private int[][] direction = new int[][]{{1, 0},{-1, 0},{0, 1},{0, -1}};

    public void solve(char[][] board){
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O' && (i == 0 || i == m - 1 || j == 0 || j == n - 1)){
                    dfs(board, i, j);
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#'){
            return;
        }
        board[i][j] = '#';
        for(int[] dir: direction){
            dfs(board, i + dir[0], j + dir[1]);
        }
    }
}
