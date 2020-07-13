package com.yy.math.dp;

/**
 * Created by Administrator on 2020/7/13.
 */
public class NumTrees {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[n] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
