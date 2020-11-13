package com.practice200.traceBack;

import java.util.*;

public class Permute2 {
    public static void main(String[] args) {
        System.out.println(new Permute2().permute(new int[]{1, 1, 2}));
    }

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        //定义一个数组记录该数字是否被访问过
        boolean[] visit = new boolean[nums.length];
        LinkedList<Integer> track = new LinkedList<>();
        dfs(nums,visit, track, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] visit, LinkedList<Integer> track, List<List<Integer>> res){
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visit[i]){
                continue;
            }
            //数字相同，且前一个数字没有被访问过
            if(i > 0 && nums[i] == nums[i - 1] && !visit[i - 1]){
                continue;
            }
            track.add(nums[i]);
            visit[i] = true;
            dfs(nums, visit, track, res);
            visit[i] = false;
            track.removeLast();
        }
    }
}
