package com.yy.math;

import java.util.HashMap;

/**
 * Created by Administrator on 2020/6/12.
 */
public class LongestSubstring {
    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        int pwwkew = longestSubstring.lengthOfLongestSubstring("pwwkew");
        System.out.println(pwwkew);
    }

    /**
     *使用 window 作为计数器记录窗口中的字符出现次数，然后先向右移动 right，
     * 当 window 中出现重复字符时，开始移动 left 缩小窗口
     * 我们要求的是最长子串，所以需要在每次移动 right 增大窗口时更新 res，
     * 而不是像之前的题目在移动 left 缩小窗口时更新 res。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s){
        if(s.length() == 0){
            return 0;
        }
        int left= 0;
        int right = 0;
        int res = 0;
        char[] ss = s.toCharArray();
        HashMap<Character, Integer> window = new HashMap<>();
        while(right < s.length()){
            char c = ss[right];
            //每次移动right时，对当前的字符个数加1
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++;
            //当前字符个数大于1时，需要开始移动左指针left
            while(window.get(c) > 1){
                char c2 = ss[left];
                //左指针移动时，对当前左指针指向的字符减1

                window.put(c2, window.getOrDefault(c2, 0) - 1);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
