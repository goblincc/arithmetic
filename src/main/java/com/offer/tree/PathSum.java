package com.offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 */
public class PathSum {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        backTracking(root, sum, new LinkedList<>());
        return res;
    }

    private void backTracking(TreeNode node, int target, LinkedList<Integer> path){
        if(node == null){
            return;
        }
        path.add(node.val);
        target -= node.val;
        if(target == 0 && node.left == null && node.right == null){
            res.add(new ArrayList<>(path));
        }else{
            backTracking(node.left, target, path);
            backTracking(node.right, target, path);
        }
        path.removeLast();
    }
}
