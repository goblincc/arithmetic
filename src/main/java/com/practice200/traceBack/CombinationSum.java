package com.practice200.traceBack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        LinkedList<Integer> list = new LinkedList<>();
        track(candidates, 0, target, list, res);
        return res;
    }

    public void track(int[] candiates, int start, int target, LinkedList<Integer> list, List<List<Integer>> res){
        if(target == 0){
            res.add(new LinkedList<>(list));
            return;
        }
        //注意此处i的取值， 如果从0开始， 则结果会出现重复[[2, 2, 3], [2, 3, 2], [3, 2, 2], [7]] 请细品！！！
        //从每一层的第 22 个结点开始，都不能再搜索产生同一层结点已经使用过的 candidate 里的元素
        for(int i = start; i < candiates.length; i++){
            if(candiates[i] <= target){
                list.addLast(candiates[i]);
                track(candiates, i, target - candiates[i], list, res);
                list.removeLast();
            }
        }
    }
}
