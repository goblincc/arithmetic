package com.yy.math;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2020/6/10.
 */
public class Permutation {
    List<List<Integer>> res = new LinkedList<>();
    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        List<List<Integer>> permuta = permutation.permuta(new int[]{1, 1, 3});
        System.out.println(permuta);
    }

    List<List<Integer>> permuta(int[] nums){
        LinkedList<Integer> track = new LinkedList<>();
//        backTrack(nums, track, new boolean[nums.length]);
        backTrack2(nums, track, new boolean[nums.length]);
        return res;
    }

    void backTrack(int[] nums, LinkedList<Integer> track, boolean[] visited){
        if(track.size() == nums.length){
            res.add(new LinkedList(track));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            track.add(nums[i]);
            visited[i] = true;
            backTrack(nums, track, visited);
            track.removeLast();
            visited[i] = false;
        }

    }


    void backTrack2(int[] nums, LinkedList<Integer> track, boolean[] visited){
        if(track.size() == nums.length){
            res.add(new LinkedList(track));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            track.add(nums[i]);
            visited[i] = true;
            backTrack2(nums, track, visited);
            track.removeLast();
            visited[i] = false;
        }
    }
}
