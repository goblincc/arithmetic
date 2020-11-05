package com.practice200.bfsAndDFs;

public class NumIslands {
    private int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int numIslands(char[][] grid){
        if(grid.length == 0 || grid == null){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != '0'){
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        for(int[] dir : direction){
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}
