package com.yy.math.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2020/6/17.
 */
public class ListOfDepth {
    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null) return new ListNode[0];
        List<ListNode> res = new ArrayList<>();
        Queue<TreeNode>  queue = new LinkedList<>();
        queue.add(tree);
        while(!queue.isEmpty()){
            int size = queue.size();
            ListNode root = null;
            ListNode rear = null;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(i == 0){
                    root = rear = new ListNode(node.val);
                }else{
                    //注意不断更新节点的方式
                    rear = rear.next = new ListNode(node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(root);
        }
        return res.toArray(new ListNode[res.size()]);
    }

    //错误的解法，for循环
    public ListNode[] listOfDepth2(TreeNode tree) {
        if(tree == null) return new ListNode[0];
        List<ListNode> res = new ArrayList<>();
        Queue<TreeNode>  queue = new LinkedList<>();
        queue.add(tree);
        while(!queue.isEmpty()){
            ListNode root = null;
            ListNode rear = null;
            for(int i = queue.size(); i > 0; i--){
                System.out.println("i:"+i);
                System.out.println("queue.size():"+queue.size());
                TreeNode node = queue.poll();
                //由于执行了queue.poll()， queue.size()已改变，i不会等于queue.size()
                if(i == queue.size()){
                    root = rear = new ListNode(node.val);
                }else{
                    ListNode n = new ListNode(node.val);
                    rear = rear.next = n;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(root);
        }
        return res.toArray(new ListNode[res.size()]);
    }

}
