package com.practice200.traceBack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
    }
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new LinkedList<Integer>());
        return res;
    }

    private void backtrack(int start, int[] nums, List<List<Integer>> res, LinkedList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(i + 1, nums, res, tmp);
            tmp.removeLast();
        }
    }
}
