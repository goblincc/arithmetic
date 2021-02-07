package com.offer.tree;

/**
 * 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommoAncestor(TreeNode root, TreeNode p, TreeNode q){
        while(root != null){
            if(root.val < p.val && root.val < q.val){
                root = root.right;
            }else if(root.val > p.val && root.val > q.val){
                root = root.left;
            }else break;
        }
        return root;
    }
}
