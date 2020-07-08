package com.yy.math;

/**
 * Created by Administrator on 2020/6/16.
 */
public class NumEnclaves {
    /**
     * 解题思路：找出边界点的0， 然后找到与边界点相连的0，将其变为1， 剩下的0的个数就是要找的结果
     * @param A
     * @return
     */
    public int numEnclaves(int[][] A) {
        if(A.length == 0) return 0;
        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isEdge = i == 0 || i == m - 1 || j == 0 || j == n - 1;
                if(isEdge && A[i][j] == 1){
                    dfs(A, i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(A[i][j] == 1){
                    res += 1;
                }
            }
        }
        return res;
    }

    public void dfs(int[][]A, int i, int j){
        if(i < 0 || j < 0 || i >= A.length || j >= A[0].length || A[i][j] == 0){
           return;
        }
        A[i][j] = 0;
        dfs(A, i - 1, j);
        dfs(A, i + 1, j);
        dfs(A, i, j - 1);
        dfs(A, i, j + 1);
    }

}
