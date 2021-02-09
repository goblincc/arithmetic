package com.offer.tree;

/**
 * Created by chenchang on 2021/2/8 11:16.
 * 二叉树两个节点最近的公共祖先
 */
public class LowestCommonAncestor2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null){
            return null;
        }else if(left == null){
            return right;
        }else if(right == null){
            return left;
        }else {
            return root;
        }
    }
}
