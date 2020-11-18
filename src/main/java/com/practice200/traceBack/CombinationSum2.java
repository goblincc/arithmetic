package com.practice200.traceBack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        LinkedList<Integer> list = new LinkedList<>();
        track(candidates, 0, target, list, res);
        return res;
    }

    public void track(int[] candiates, int start, int target, LinkedList<Integer> list, List<List<Integer>> res){
        if(target == 0){
            res.add(new LinkedList<>(list));
            return;
        }
        for(int i = start; i < candiates.length; i++){
            if(candiates[i] <= target){
                if(i > start && candiates[i] == candiates[i - 1]){
                    continue;
                }
                list.addLast(candiates[i]);
                track(candiates, i + 1, target - candiates[i], list, res);
                list.removeLast();
            }
        }
    }
}
