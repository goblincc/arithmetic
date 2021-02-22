package com.offer.tree;

/**
 * Created by chenchang on 2021/2/7 19:18.
 * 二叉树的深度
 */
public class TreeDepth {
    public int treeDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }
}
