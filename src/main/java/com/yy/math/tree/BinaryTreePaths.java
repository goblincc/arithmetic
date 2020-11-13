package com.yy.math.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePaths {

//    public List<String> binaryTreePaths(TreeNode root){
//        List<String> res = new LinkedList<>();
//        if(root == null){
//            return res;
//        }
//        LinkedList<String> path = new LinkedList<>();
//        dfs(root, path, res);
//        return res;
//    }

//    private void dfs(TreeNode root, LinkedList<String> path, List<String> res){
//        if(root != null){
//            LinkedList<String> path_d = new LinkedList<>(path);
//            path_d.addLast(Integer.toString(root.val));
//            if(root.left == null && root.right == null){
//                res.add(String.join("->", path_d));
//            }else{
//                dfs(root.left, path_d, res);
//                dfs(root.right, path_d, res);
//            }
//        }
//
//    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        root.left = node1;
        node1.right = node3;
        root.right = node2;
        System.out.println(new BinaryTreePaths().binaryTreePaths2(root));
    }

    public List<String> binaryTreePaths2(TreeNode root){
        List<String> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        Queue<String> pathQueue = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        pathQueue.offer(Integer.toString(root.val));
        while(!pathQueue.isEmpty()){
            TreeNode node = queue.poll();
            String path = pathQueue.poll();
            if(node.left == null && node.right == null){
                res.add(path);
            }else{
                if(node.left != null){
                    queue.offer(node.left);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
                }
                if(node.right != null){
                    queue.offer(node.right);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
                }
            }
        }

        return res;
    }

}
