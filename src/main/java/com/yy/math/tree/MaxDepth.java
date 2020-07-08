package com.yy.math.tree;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by Administrator on 2020/6/15.
 */
public class MaxDepth {
    /**
     * 递归解法
     * @param root
     * @return
     */
    public int maxDepth(Node root){
        if(root == null){
            return 0;
        }else if(root.children.isEmpty()){
            return 1;
        }else{
            List<Integer> res = new ArrayList<>();
            for(Node node: root.children){
                res.add(maxDepth(node));
            }
            return Collections.max(res) + 1;
        }
    }

    /**
     * 迭代解法
     * @param root
     * @return
     */
    public int maxDepth2(Node root){
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        if(root != null){
            queue.add(new Pair<Node, Integer>(root, 1));
        }
        int depth = 0;
        while(!queue.isEmpty()){
            Pair<Node, Integer> poll = queue.poll();
            Node node = poll.getKey();
            int cur_depth = poll.getValue();
            if(!node.children.isEmpty()){
                depth = Math.max(cur_depth, depth);
                for(Node temp_node: node.children){
                    queue.add(new Pair<Node, Integer>(temp_node, cur_depth + 1));
                }
            }
        }
        return depth;
    }
}
