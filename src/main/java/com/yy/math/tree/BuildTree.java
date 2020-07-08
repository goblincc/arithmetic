package com.yy.math.tree;

import java.util.HashMap;

/**
 * Created by Administrator on 2020/6/15.
 */
public class BuildTree {
    public static void main(String[] args) {

    }

    HashMap<Integer, Integer> idxMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder){
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }
        TreeNode treeNode = myBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return treeNode;
    }

    public TreeNode myBuildTree(int[] preorder, int pre_left , int pre_right, int[] inorder, int in_left, int in_right){
        if(pre_left > pre_right || in_left > in_right){
            return null;
        }
        //前序遍历的第一个节点一定是树的根节点
        TreeNode root = new TreeNode(preorder[pre_left]);
        //找到根节点在中序遍历中的索引，根据该索引将前序遍历分为左子树和右子树
        int inorder_root = idxMap.get(preorder[pre_left]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - in_left;
        root.left = myBuildTree(preorder, pre_left + 1, pre_left + size_left_subtree, inorder, in_left, inorder_root - 1);
        root.right = myBuildTree(preorder, pre_left + size_left_subtree + 1, pre_right, inorder, inorder_root + 1, in_right);
        return root;
    }
}
