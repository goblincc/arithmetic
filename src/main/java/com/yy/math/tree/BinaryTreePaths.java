package com.yy.math.tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root){
        List<String> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        LinkedList<String> path = new LinkedList<>();
        dfs(root, path, res);
        return res;
    }

    private void dfs(TreeNode root, LinkedList<String> path, List<String> res){
        if(root != null){
            LinkedList<String> path_d = new LinkedList<>(path);
            path_d.addLast(Integer.toString(root.val));
            if(root.left == null && root.right == null){
                res.add(String.join("->", path_d));
            }else{
                dfs(root.left, path_d, res);
                dfs(root.right, path_d, res);
            }
        }

    }

}
