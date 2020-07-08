package com.yy.math.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/6/22.
 */
public class MultiSearch {

    class Node{
        //需要构建的字符串的id
        int id;
        //理论上每个节点都可能包含26个值
        Node[] childs = new Node[26];
        //判断当前字符是不是叶子节点， 从根节点到叶子节点就是一个完整的字符串
        boolean isLeaf = false;
    }
    private Node root;
    //添加字符串的方法
    private void addWord(String word, int id){
        Node node = root;
        for(char c: word.toCharArray()){
            if(node.childs[c - 'a'] == null){
                node.childs[c - 'a'] = new Node();
            }
            node = node.childs[c - 'a'];
        }
        node.isLeaf = true;
        node.id = id;
    }

    public int[][] multiSearch(String big, String[] smalls) {
        root = new Node();
        int n = smalls.length;
        List<Integer>[] res = new List[n];
        for (int i = 0; i < n; i++) {
            res[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            addWord(smalls[i], i);
        }
        outer:
        for(int i = 0; i < big.length(); i++){
            Node node = root;
            for (int j = i; j < big.length(); j++) {
                char c = big.charAt(j);
                if(node.childs[c - 'a'] == null){
                    continue outer;
                }
                node = node.childs[c - 'a'];
                if(node.isLeaf){
                    res[node.id].add(i);
                }
            }
        }

        int[][] resArr = new int[n][];
        for (int i = 0; i < n; i++) {
            resArr[i] = new int[res[i].size()];
            for (int j = 0; j < resArr[i].length; j++) {
                resArr[i][j] = res[i].get(j);
            }
        }
        return resArr;
    }
}
