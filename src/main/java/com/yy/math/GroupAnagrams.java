package com.yy.math;

import java.util.*;

/**
 * Created by Administrator on 2020/6/23.
 */
public class GroupAnagrams {
    public static void main(String[] args) {
//        String s = "bac";
//        System.out.println(new GroupAnagrams().sort(s));
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }

    /**
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     输出:
     [
     ["ate","eat","tea"],
     ["nat","tan"],
     ["bat"]
     ]
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //map中的key为每个单词排序后的值，value为单词的原始值组成的列表
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String s: strs){
            String temp = sort(s);
            if(!map.containsKey(temp)){
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(temp, list);
            }else{
                ArrayList<String> list = map.get(temp);
                list.add(s);
                map.put(temp, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, ArrayList<String>> entry: map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    public String sort(String s){
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for(char c: chars){
            sb.append(c);
        }
        return sb.toString();
    }
}
