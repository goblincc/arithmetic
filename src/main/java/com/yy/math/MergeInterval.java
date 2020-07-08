package com.yy.math;

import java.util.*;

/**
 * Created by Administrator on 2020/6/11.
 */
public class MergeInterval {
    public static void main(String[] args) {
//        int[][] intervals = new int[][]{{1, 3}, {8, 10},{2, 6}, {15, 18}};
        int[][] intervals = new int[][]{{1, 4}, {4, 5}};
        MergeInterval mergeInterval = new MergeInterval();
        int[][] merge = mergeInterval.merge(intervals);
        List<int[]> ints = Arrays.asList(merge);
        for(int[] temp: ints){
            System.out.println(temp[0]+ ":" + temp[1]);
        }
    }

    /**
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[][]{};
        }
        //对二维数组按第一个元素升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        //将第一个数组放入列表中，每次去更新列表中的最后一个元素
        res.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int value = res.get(res.size() - 1)[1];
            if(value >= intervals[i][0]){
                res.get(res.size() - 1)[1] = Math.max(value, intervals[i][1]);
            }else{
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }


}
