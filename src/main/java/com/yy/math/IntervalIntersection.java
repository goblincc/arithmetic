package com.yy.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/6/11.
 */
public class IntervalIntersection {
    public static void main(String[] args) {
        int[][] nums1 = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] nums2 = new int[][]{{1,5},{8,12},{15,24},{25,26}};
        IntervalIntersection intervalIntersection = new IntervalIntersection();
        List<List<Integer>> lists = intervalIntersection.intervalIntersection(nums1, nums2);
        System.out.println(lists.toString());
    }

    /**
     * 输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
     * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
     * @param nums1
     * @param nums2
     * @return
     */
    public List<List<Integer>> intervalIntersection(int[][] nums1, int[][] nums2){
        if(nums1.length == 0 || nums2.length == 0){
            return null;
        }
        int i = 0;
        int j = 0;
        List<List<Integer>> res = new ArrayList<>();
        while(i < nums1.length && j < nums2.length){
            int a1 = nums1[i][0];
            int a2 = nums1[i][1];
            int b1 = nums2[j][0];
            int b2 = nums2[j][1];
            if(a2 >= b1 && b2 >= a1){
                List<Integer> list = new ArrayList<>();
                int min = Math.max(a1, b1);
                int max = Math.min(a2, b2);
                list.add(min);
                list.add(max);
                res.add(list);
            }
            if(b2 <= a2){
                j++;
            }else{
                i++;
            }
        }
        return res;
    }


    public int[][] intervalIntersection2(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi)
                ans.add(new int[]{lo, hi});

            // Remove the interval with the smallest endpoint
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }

        return ans.toArray(new int[ans.size()][]);
    }

}
