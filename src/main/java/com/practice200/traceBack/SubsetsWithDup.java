package com.practice200.traceBack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
 * 说明：解集不能包含重复的子集
 */
public class SubsetsWithDup {
    public static void main(String[] args) {
        System.out.println(new SubsetsWithDup().subsetsWithDup(new int[]{1, 2, 2}));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        LinkedList<Integer> list = new LinkedList<>();
        boolean[] visit = new boolean[nums.length];
        track(nums, 0, visit, list, res);
        return res;
    }

    public void track(int[] nums, int start, boolean[] visit, LinkedList<Integer> list, List<List<Integer>> res){
        res.add(new LinkedList<>(list));
        for(int i = start; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && !visit[i - 1]){
                continue;
            }
            list.add(nums[i]);
            visit[i] = true;
            track(nums, i + 1, visit, list, res);
            visit[i] = false;
            list.removeLast();
        }
    }
}
