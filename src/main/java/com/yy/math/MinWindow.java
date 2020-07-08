package com.yy.math;

import java.util.HashMap;

/**
 * Created by Administrator on 2020/6/11.
 */
public class MinWindow {
    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
//        System.out.println(minWindow.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow.minWindow("a", "b"));
    }

    /**
     * 用一个哈希表 needs 记录字符串 t 中包含的字符及出现次数，
     * 用另一个哈希表 window 记录当前「窗口」中包含的字符及出现的次数，
     * 如果 window 包含所有 needs 中的键，且这些键对应的值都大于等于 needs 中的值，
     * 那么就可以知道当前「窗口」符合要求了，可以开始移动 left 指针了
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t){
        if(s.length() == 0) return "";
        if(s.length() < t.length()) return "";
        //记录窗口内目标字符的个数
        HashMap<Character, Integer> window = new HashMap<>();
        //记录目标字符的个数
        HashMap<Character, Integer> needs = new HashMap<>();
        char[] tt = t.toCharArray();
        for(char temp: tt){
            needs.put(temp, needs.getOrDefault(temp, 0) + 1);
        }
        int left = 0 , right = 0;
        int match = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        char[] ss = s.toCharArray();

        while(right < ss.length){
            if(needs.containsKey(ss[right]) ){
                window.put(ss[right], window.getOrDefault(ss[right], 0) + 1);
                //两个map中同一个key的值相同，说明匹配到一个字符
                //注意：Integer不能用==比较，要用compareTo
                if(window.get(ss[right]).compareTo(needs.get(ss[right])) == 0){
                    match++;
                }
            }
            right++;
            //在右指针右移的过程中，如果完全匹配，此时暂停右指针移动，开始操作左指针，减小范围
            while(match == needs.size()){
                if(right - left < minLen){
                    start = left;
                    minLen = right - left;
                }
                //在left移动的过程中，如果移掉了一个目标字符，match就要减1
                if(needs.containsKey(ss[left])){
                    window.put(ss[left], window.getOrDefault(ss[left], 0) - 1);
                    if(window.get(ss[left]) < needs.get(ss[left])){
                        match--;
                    }
                }
                left++;
            }
        }

        System.out.println("start:" + start);
        System.out.println("left:" + left);
        System.out.println("minLen:" + minLen);

        return minLen == Integer.MAX_VALUE ? "":s.substring(start, minLen + start);
    }
}
