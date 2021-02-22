package com.offer.exercise;

/**
 * Created by chenchang on 2021/2/8 15:58.
 *  机器人运动范围
 */
public class MovingCount {
    public int movingCount(int m, int n, int k){
        boolean[][] vist = new boolean[m][n];
        return dfs(vist, m, n, k, 0, 0);

    }

    private int dfs(boolean[][] visit, int m, int n, int k, int i, int j){
        if(i >=m || j >= n || visit[i][j] || bitSum(i) + bitSum(j) > k){
            return 0;
        }
        visit[i][j] = true;
        return 1 + dfs(visit, m, n, k, i + 1, j) + dfs(visit, m, n, k, i, j + 1);
    }

    /**
     * 数位和  如：23 =》 2 + 3
     * @param n
     * @return
     */
    private int bitSum(int n){
        int s = 0;
        while(n > 0){
            s += n % 10;
            n /= 10;
        }
        return s;
    }

}
