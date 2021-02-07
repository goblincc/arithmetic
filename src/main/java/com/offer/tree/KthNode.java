package com.offer.tree;

/**
 * Created by chenchang on 2021/2/7 16:51.
 *
 * 利用中序遍历求二叉树第k小的节点
 */
public class KthNode {
    TreeNode res;
    int cnt;

    public TreeNode kthNode(TreeNode root, int k){
        inOrder(root, k);
        return res;
    }

    private void inOrder(TreeNode root, int k){
        if(root == null || cnt > k){
            return;
        }
        inOrder(root.left, k);
        cnt++;
        if(cnt == k){
            res = root;
        }
        inOrder(root.right, k);
    }

}
