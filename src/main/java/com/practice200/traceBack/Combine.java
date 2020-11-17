package com.practice200.traceBack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
 */
public class Combine {
    public static void main(String[] args) {
        System.out.println(new Combine().combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0 || n < k){
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        track(n, k, 1, path, res );
        return res;
    }

    public void track(int n, int k, int begin, LinkedList<Integer> path, List<List<Integer>> res){
        if(path.size() == k){
            res.add(new LinkedList<>(path));
            return;
        }
        for(int i = begin; i <= n; i++){
            if(path.contains(i)){
                continue;
            }

            path.addLast(i);
            track(n, k, i + 1, path, res);
            path.removeLast();
        }
    }
}
