package com.offer.tree;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像
 */
public class Mirror {

    public void mirror(TreeNode root){
        if(root == null){
            return;
        }
        swap(root);
        mirror(root.left);
        mirror(root.right);
    }

    private void swap(TreeNode root){
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }
}
