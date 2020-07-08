package com.yy.math.dp;



import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2020/7/1.
 */
public class Rob {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int rob = new Rob().rob2(nums);
        System.out.println(rob );
    }

    /**
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums){
        int n = nums.length;
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }

    /**
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums){
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        return Math.max(robHelp(nums, 0, len - 2), robHelp(nums, 1, len - 1));
    }

    public int robHelp(int[] nums, int start , int end){
        int[] dp = new int[nums.length + 2];
        for (int i = end; i >= start; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[start];
    }

    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob3(TreeNode root){
        if(root == null) return 0;
        if(map.containsKey(root)){
            return map.get(root);
        }
        int val = root.val;
        int do_it = val + (root.left== null ? 0: rob3(root.left.left) + rob3(root.left.right)) +
                (root.right== null ? 0: rob3(root.right.left) + rob3(root.right.right));
        int not_do_it = rob3(root.left) + rob3(root.right);
        int res = Math.max(do_it, not_do_it);
        map.put(root, res);
        return res;
    }
}
