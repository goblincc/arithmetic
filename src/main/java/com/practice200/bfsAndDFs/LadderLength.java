package com.practice200.bfsAndDFs;

import javafx.util.Pair;

import java.util.*;

/**
 * 127  单词接龙
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 *
 * BFS
 */
public class LadderLength {
    public static void main(String[] args) {
        String beginWord = "cot";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dog");
        wordList.add("cog");
        System.out.println(new LadderLength().ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //给定的列表中不包含结束词， 直接返回0
        if(!wordList.contains(endWord)){
            return 0;
        }
        int len = beginWord.length();
        //处理给出的单词字典， 转换为全部的通用状态及每个通配词映射的单词集合
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>();

        wordList.forEach(curword ->{
            //每个单词能得到len种通配词（每个位置都可以为*）
            for(int i = 0; i < len; i++){
                //获取通配词
                String comboWord = curword.substring(0, i) + "*" + curword.substring(i + 1, len);
                //组装通配词字典  例如 "h*t" -> [hot, hit, hat]
                ArrayList<String> comboWordList = allComboDict.getOrDefault(comboWord, new ArrayList<>());
                comboWordList.add(curword);
                allComboDict.put(comboWord, comboWordList);
            }
        });

        //广度优先遍历
        Queue<Pair<String , Integer>> queue = new LinkedList<>();
        //记录已经遍历过的词
        HashMap<String, Boolean> hasVisitedList = new HashMap<>();
        queue.add(new Pair<>(beginWord, 1));
        while(!queue.isEmpty()){
            Pair<String ,Integer> node = queue.poll();
            String curWord = node.getKey();
            int level = node.getValue();
            for(int i = 0; i < len; i++){
                //从当前词得到len个通配词
                String currComboWord = curWord.substring(0, i) + "*" + curWord.substring(i + 1, len);
                //拿到当前词的通配词对应的单词集合
                ArrayList<String> currComboList = allComboDict.getOrDefault(currComboWord, new ArrayList<>());
                //判断集合中是否包含结束词
                for(String word: currComboList){
                    if(word.equals(endWord)){
                        return level + 1;
                    }
                    //将能得到的词且没有访问过的词加入队列中， 并标记已访问
                    if(!hasVisitedList.containsKey(word)){
                        queue.add(new Pair<String, Integer>(word, level + 1));
                        hasVisitedList.put(word, true);
                    }
                }
            }
        }
        return 0;
    }
}
