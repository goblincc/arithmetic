package com.yy.math.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2020/6/17.
 */
public class Symmetric {
    /**
     * 检查左节点和右节点的值是否相等
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode m, TreeNode n){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(m);
        queue.add(n);
        while (!queue.isEmpty()){
            m = queue.poll();
            n = queue.poll();
            if(m == null && n == null){
                continue;
            }
            if(m == null || n == null || m.val != n.val){
                return false;
            }

            queue.offer(m.left);
            queue.offer(n.right);

            queue.offer(m.right);
            queue.offer(n.left);
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        return check2(root, root);
    }

    public boolean check2(TreeNode m, TreeNode n){
        if(m == null && n == null){
            return true;
        }
        if(m == null || n == null){
            return false;
        }

        return m.val == n.val && check2(m.left, n.right) && check2(m.right, n.left);
    }
}
