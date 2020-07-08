package com.yy.math.tree;

import java.util.*;

/**
 * Created by Administrator on 2020/6/17.
 */
public class DistanceK {
    //找到每个节点的父节点
    HashMap<TreeNode, TreeNode> parent = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K){
        List<Integer> list = new ArrayList<>();
        if(root == null || target == null){
            return list;
        }
        //添加过的节点
        HashSet<TreeNode> seen = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        dfs(root, null);
        //初始加入目标节点， 从目标节点开始层次遍历
        queue.add(target);
        seen.add(target);
        while (!queue.isEmpty() && K > 0){
            int size = queue.size();
            //整体遍历两次
            K--;
            while(size > 0){
                TreeNode node = queue.poll();
                //首次把target节点的左右节点和父节点加入到queue中，此时距离target节点的距离为1，
                //第二次加入左右节点和父节点的左右节点和父节点，这些节点距离target节点的距离就为2了
                //seen列表防止重复添加节点，在不为空的时候添加到queue队列
                if(node.left != null && seen.add(node.left)){
                    queue.add(node.left);
                }
                if(node.right != null && seen.add(node.right )){
                    queue.add(node.right);
                }
                if(parent.get(node) != null && seen.add(parent.get(node))){
                    queue.add(parent.get(node));
                }
                size--;
            }
        }
        while (!queue.isEmpty()){
            list.add(queue.poll().val);
        }
        return list;

    }

    public  void dfs(TreeNode node, TreeNode parent_node){
        if(parent_node != null){
            parent.put(node, parent_node);
        }
        if(node.left != null){
            dfs(node.left, node);
        }
        if(node.right != null){
            dfs(node.right, node);
        }
    }
}
