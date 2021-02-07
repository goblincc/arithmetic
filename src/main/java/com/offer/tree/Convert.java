package com.offer.tree;

/**
 * 二叉搜索树与双向链表
 */
public class Convert {
    TreeNode pre;
    TreeNode head;
    public TreeNode convert(TreeNode root){
        inOrder(root);
//        双向循环链表
//        pre.right = head;
//        head.left = pre;
        return head;
    }

    private void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        node.left = pre;
        if(pre != null){
            pre.right = node;
        }
        pre = node;
        if(head == null){
            head = node;
        }
        inOrder(node.right);
    }
}
