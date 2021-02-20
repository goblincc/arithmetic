package com.offer.exercise;

import java.util.HashMap;

/**
 * Created by chenchang on 2021/2/20 16:04.
 * 滑动窗口解题
 * 给一个字符串s， 一个字符串t， 从s中找出包含t所有字母的子串
 */
public class Minwindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new Minwindow().minwindow(s, t));
    }

    public String minwindow(String s, String t){
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> needs = new HashMap<>();
        for(Character c: t.toCharArray()){
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int match = 0;

        while(right < s.length()){
            Character c = s.charAt(right);
            if(needs.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c) == needs.get(c)){
                    match++;
                }
            }
            right++;

            while(match == needs.size()){
                if(right - left < minLen){
                    start = left;
                    minLen = right - left;
                }
                char c2 = s.charAt(left);
                if(needs.containsKey(c2)){
                    window.put(c2, window.getOrDefault(c2, 0) - 1);
                    if(window.get(c2) < needs.get(c2)){
                        match--;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, right);
    }
}
