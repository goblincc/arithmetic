package com.offer.tree;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {
    public static void main(String[] args){

    }

    /**
     * 根节点、左子树、右子树只要有一个包含目标树， 就是子结构
     * @param root1
     * @param root2
     * @return
     */
    public boolean hasSubtree(TreeNode root1, TreeNode root2){
        if(root1 == null || root2 == null){
            return false;
        }
        return isSubTree(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    /**
     * 判断两棵树是否相同
     * @param root1
     * @param root2
     * @return
     */
    private boolean isSubTree(TreeNode root1, TreeNode root2){
        if(root1 == null){
            return false;
        }
        if(root2 == null){
            return true;
        }
        if(root1.val == root2.val){
            return false;
        }
        return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
    }
}
