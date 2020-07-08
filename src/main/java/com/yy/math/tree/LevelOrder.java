package com.yy.math.tree;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2020/6/16.
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){ return res;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            System.out.println("res:"+res.size());
            //注意循环的方式
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                System.out.println(res.size());
                if(res.size() % 2 == 0) {
                    list.addLast(node.val); // 偶数层 -> 队列头部
                } else {
                    list.addFirst(node.val); // 奇数层 -> 队列尾部
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(list);
        }

        return res;
    }

    public int[] levelOrder2(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            for(int i = queue.size(); i > 0; i--){
                TreeNode node = queue.poll();
                res.addLast(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        int[] val = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            val[i] = res.get(i);
        }

        return val;

    }
}
