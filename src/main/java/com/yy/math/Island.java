package com.yy.math;

/**
 * Created by Administrator on 2020/6/15.
 */
public class Island {
    public static void main(String[] args) {

    }

    /**
     * 统计封闭岛屿的数目
     * @param grid
     * @return
     */
    public int closedIsland(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //以0(陆地)为起点，逐步搜索
                if(grid[i][j] == 0){
                    if(dfs(grid, i, j)){
                        res++;
                    }
                }
            }

        }
        return res;
    }

    public boolean dfs(int[][] grid, int i , int j){
        //数组越界，搜索完成，没有碰到1， 说明没有包围，返回false
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return false;
        }
        //碰到1，在这一方向碰到水域，返回true
        if(grid[i][j] == 1){
            return true;
        }
        //搜索过的0变为1
        grid[i][j] = 1;
        boolean up = dfs(grid, i - 1, j);
        boolean down = dfs(grid, i + 1, j);
        boolean left = dfs(grid, i, j - 1);
        boolean right = dfs(grid, i, j + 1);
        if(up && down && left && right){
            return true;
        }
        return false;
    }

}
