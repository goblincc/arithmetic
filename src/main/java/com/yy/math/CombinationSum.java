package com.yy.math;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2020/6/10.
 */
public class CombinationSum {
    List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] nums = new int[]{10,1,2,7,6,1,5};
        Arrays.sort(nums);
        List<List<Integer>> lists = combinationSum.combinationSum(nums, 8);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target){
        if(nums.length == 0) return res;
        backTrack2(0, nums, new LinkedList(), target);
        return res;
    }

    public void backTrack(int first,int[] nums, LinkedList track, int target){
        if(target == 0){
            res.add(new LinkedList(track));
            return;
        }

        if(target < 0){
            return;
        }
        for(int i = first; i < nums.length; i++){
            track.add(nums[i]);
            backTrack(i, nums, track, target-nums[i]);
            track.removeLast();
        }
    }


    public void backTrack2(int first,int[] nums, LinkedList track, int target){
        if(target == 0){
            res.add(new LinkedList(track));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = first; i < nums.length; i++){
            if (i > first && nums[i] == nums[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            backTrack2(i + 1, nums, track, target-nums[i]);
            track.removeLast();
        }
    }
}
