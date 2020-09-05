package com.practice200.gred;

import java.util.Arrays;

/**
 * 每个孩子都有一个满足度 grid，每个饼干都有一个大小 size，
 * 只有饼干的大小大于等于一个孩子的满足度，
 * 该孩子才会获得满足。求解最多可以获得满足的孩子数量
 * 1.给一个孩子的饼干应当尽量小并且又能满足该孩子，这样大饼干才能拿来给满足度比较大的孩子。
 * 2.因为满足度最小的孩子最容易得到满足，所以先满足满足度最小的孩子。
 *
 */
public class FindContentChildren {
    public static void main(String[] args) {
        int[] grid = new int[]{1, 3};
        int[] size = new int[]{1, 2, 4};
        int count = new FindContentChildren().findContentChildren(grid, size);
        System.out.println(count);
    }
    public int findContentChildren(int[] grid, int[] size){
        if(grid.length == 0 || size.length == 0){
            return 0;
        }
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = 0;
        int si = 0;
        while(gi <= grid.length - 1 && si <= size.length){
            if(grid[gi] <= size[si]){
                gi++;
            }
            si++;
        }
        return gi;
    }
}
