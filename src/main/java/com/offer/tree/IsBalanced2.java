package com.offer.tree;

public class IsBalanced2 {
    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root){
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root){
        if(root == null || !isBalanced){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left - right) > 1){
            isBalanced = false;
        }
        return 1 + Math.max(left, right);
    }
}