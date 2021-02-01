package com.offer.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTree {

    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot){

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean reverse = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while(size-- > 0){
                TreeNode node = queue.poll();
                if(node == null){
                    continue;
                }
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);

            }
            reverse = !reverse;
            if(reverse){
                Collections.reverse(list);
            }
            if(list.size() > 0){
                res.add(list);
            }
        }
        return res;
    }
}
