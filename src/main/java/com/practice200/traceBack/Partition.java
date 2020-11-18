package com.practice200.traceBack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class Partition {
    public static void main(String[] args) {
        System.out.println(new Partition().isPlaindrom("abba", 0, 3));
        System.out.println(new Partition().partition("aba"));
    }

    public List<List<String>> partition(String s){
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }
        LinkedList<String> list = new LinkedList<>();
        track(s, list, res);
        return res;
    }

    public void track(String s, LinkedList<String> list, List<List<String>> res){
        if(s.length() == 0){
            res.add(new LinkedList<>(list));
            return;
        }
        for(int i = 0; i < s.length(); i++){
            if(isPlaindrom(s, 0, i)){
                list.add(s.substring(0, i + 1));
                track(s.substring(i + 1), list, res);
                list.removeLast();
            }
        }
    }

    public boolean isPlaindrom(String s, int begin, int end){
        while (begin <= end){
            if(s.charAt(begin++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
