package com.practice200.traceBack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute {
    private List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{1, 2, 3}));
    }
    public  List<List<Integer>> permute(int[] nums){
        if(nums == null || nums.length == 0){
            return res;
        }
        LinkedList<Integer> track = new LinkedList<>();
        traceBack(nums, track);
        return res;
    }

    private void traceBack(int[] nums, LinkedList<Integer> track){
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            traceBack(nums, track);
            track.removeLast();
        }
    }
}
