package com.yy.math.tree;

import java.util.LinkedList;

/**
 * Created by Administrator on 2020/6/15.
 */
public class LeafSimilar {


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        return list1.equals(list2);
    }

    public void dfs(TreeNode root, LinkedList<Integer> list){
        if(root != null){
            if(root.left == null && root.right == null){
                list.add(root.val);
            }
            dfs(root.left, list);
            dfs(root.right, list);
        }
    }
}
