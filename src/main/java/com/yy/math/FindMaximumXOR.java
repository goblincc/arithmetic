package com.yy.math;

import com.yy.math.tree.TreeNode;

/**
 * Created by Administrator on 2020/6/28.
 */
public class FindMaximumXOR {
    public static void main(String[] args) {
        int[] nums = new int[]{3,10,5,25,2,8};
        int maximumXOR = new FindMaximumXOR().findMaximumXOR(nums);
        System.out.println(maximumXOR);

    }

    class TrieNode{
        TrieNode[] childs = new TrieNode[2];
    }

    public int findMaximumXOR(int[] nums){
        int maxNum = nums[0];
        for(int num : nums){
            maxNum = Math.max(maxNum, num);
        }
        //找到二进制最长度
        int L = (Integer.toBinaryString(maxNum)).length();
        int n = nums.length;
        String[] strNums = new String[n];
        //右移L位，例如L= 3，则bitmask = 1000
        int bitmask = 1 << L;
        //将数字转为二进制字符串，左侧空位补0
        for (int i = 0; i < n; i++) {
            strNums[i] = Integer.toBinaryString(nums[i] | bitmask).substring(1);
        }
        //构建字典树
        TrieNode trie = new TrieNode();
        int maxXor = 0;
        for(String num: strNums){
            TrieNode node = trie;
            TrieNode xorNode = trie;
            int currXor = 0;
            for(Character bit: num.toCharArray()){
                if(node.childs[bit - '0'] == null){
                    node.childs[bit - '0'] = new TrieNode();
                }
                node = node.childs[bit - '0'];

                //如果当前比特值存在互补比特值，访问具有互补比特值的孩子节点，并在异或值最右侧附加一个 1
                //如果不存在，直接访问具有当前比特值的孩子节点，并在异或值最右侧附加一个 0
                Character toggledBit = bit == '1' ? '0' : '1';
                if(xorNode.childs[toggledBit - '0'] == null){
                    currXor = currXor << 1;
                    xorNode = xorNode.childs[bit - '0'];
                }else{
                    currXor = currXor << 1 | 1;
                    xorNode = xorNode.childs[toggledBit - '0'];
                }
            }

            maxXor = Math.max(maxXor, currXor);
        }

        return maxXor;
    }
}
