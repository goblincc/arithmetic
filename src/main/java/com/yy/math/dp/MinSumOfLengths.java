package com.yy.math.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Administrator on 2020/7/6.
 */
public class MinSumOfLengths {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 1};
        int target = 7;
        int i = new MinSumOfLengths().minSumOfLengths(arr, target);
        System.out.println(i);
    }
    public int minSumOfLengths(int[] arr, int target) {
        int m = arr.length;
        int[] preSum = new int[m + 1];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            preSum[i + 1] = preSum[i] + arr[i];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < i; j++) {
               if(preSum[i] - preSum[j] == target){
                   list.add(i - j);
               }
            }
        }
        int res;
        if(list.size() <= 1){
            return -1;
        }else{
            Collections.sort(list);
            res = list.get(0) + list.get(1);
        }
        return res;
    }
}
