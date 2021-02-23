package com.offer.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by chenchang on 2021/2/8 16:10.
 * 全排列问题
 */
public class Permutation {
    public static void main(String[] args) {
        String[] strs = new Permutation().permutation("abc");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }

    List<String> res = new ArrayList<>();
    char[] c;

    public String[] permutation(String s){
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int x){
        if(x == c.length - 1){
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++){
            if(set.contains(c[i])){
                continue;
            }
            set.add(c[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    private void swap(int a, int b){
       char temp = c[a];
       c[a] = c[b];
       c[b] = temp;
    }
}
