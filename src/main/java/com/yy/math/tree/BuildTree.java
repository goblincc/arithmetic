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
        TreeNode treeNode = myBuildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return treeNode;
    }

    /**
     *  前序数组拿到树的根节点，找到根节点在中序数组中的索引， 判断左右子树在前序数组中的位置
     * @param preorder 前序遍历数组
     * @param pre_left 前序左子树数组的起始索引
     * @param pre_right 前序左子树的最后一个索引
     * @param in_left  中序数组起始索引
     * @param in_right  中序数组末尾索引
     * @return
     */
    public TreeNode myBuildTree(int[] preorder, int pre_left , int pre_right, int in_left, int in_right){
        if(pre_left > pre_right || in_left > in_right){
            return null;
        }
        //前序遍历的第一个节点一定是树的根节点
        TreeNode root = new TreeNode(preorder[pre_left]);
        //找到根节点在中序遍历中的索引，根据该索引将前序遍历分为左子树和右子树
        int inorder_root = idxMap.get(preorder[pre_left]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - in_left;
        root.left = myBuildTree(preorder, pre_left + 1, pre_left + size_left_subtree, in_left, inorder_root - 1);
        root.right = myBuildTree(preorder, pre_left + size_left_subtree + 1, pre_right, inorder_root + 1, in_right);
        return root;
    }
}
