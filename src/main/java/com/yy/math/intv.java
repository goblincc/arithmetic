package com.yy.math;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Administrator on 2020/6/3.
 */
public class intv {
    public static void main(String[] args) {

    }

    public int intervalSchedule(int[][] intvs) {
        if(intvs.length == 0) return 0;
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[1] - a2[1];
            }
        });
        int count = 1;
        int x_end = intvs[0][0];
        for(int[] intv: intvs){
            if(intv[0] >= x_end){
                count++;
                x_end = intv[1];
            }
        }
        return count;
    }
}
