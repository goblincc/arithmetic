package com.offer.tree;

import java.util.HashMap;

public class ReBuildTree {
    private HashMap<Integer, Integer> orderMap = new HashMap<>();
    public TreeNode reBuildTree(int[] pre, int[] order){
        for (int i = 0; i < order.length; i++) {
            orderMap.put(order[i], i);
        }
        return reBuild(pre, 0, pre.length - 1, 0, order.length - 1);
    }

    private TreeNode reBuild(int[] pre, int preleft, int preright, int orderleft, int orderright){
        if(preleft > preright || orderleft > orderright){
            return null;
        }
        TreeNode root = new TreeNode(pre[preleft]);
        int orderIndex = orderMap.get(pre[preleft]);
        int leftSize = orderIndex - orderleft;
        root.left = reBuild(pre, preleft + 1, preleft + leftSize, orderleft, orderIndex - 1);
        root.right = reBuild(pre, preleft + leftSize + 1, orderIndex + 1, orderIndex + 1, orderright);
        return root;
    }
}
