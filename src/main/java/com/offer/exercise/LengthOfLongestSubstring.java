package com.offer.exercise;

import java.util.HashMap;

/**
 * Created by chenchang on 2021/2/20 16:29.
 * 滑动窗口
 * 不重复字母的最长子串长度
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s){
        int res = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;

        while(right < s.length()){
            Character c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++;

            while(window.get(c) > 1){
                char c2 = s.charAt(left);
                window.put(c2, window.get(c2)- 1);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
