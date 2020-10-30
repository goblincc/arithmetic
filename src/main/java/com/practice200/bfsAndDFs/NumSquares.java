package com.practice200.bfsAndDFs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少
 * 1.首先，我们准备小于给定数字 n 的完全平方数列表
 * 2.然后创建 queue 遍历，该变量将保存所有剩余项在每个级别的枚举
 * 在主循环中，我们迭代 queue 变量。在每次迭代中，我们检查余数是否是一个完全平方数。
 * 如果余数不是一个完全平方数，就用其中一个完全平方数减去它，得到一个新余数，然后将新余数添加到 next_queue 中，
 * 以进行下一级的迭代。一旦遇到一个完全平方数的余数，我们就会跳出循环，这也意味着我们找到了解。
 *
 */
public class NumSquares {
    public static void main(String[] args) {
        System.out.println(new NumSquares().numSquares(3));
    }
    public int numSquares(int n){
        ArrayList<Integer> square_nums = new ArrayList<>();
        for(int i = 0; i * i <= n; i++){
            square_nums.add(i * i);
        }
        Set<Integer> queue = new HashSet<>();
        queue.add(n);
        int level = 0;
        while(queue.size() > 0){
            level++;
            Set<Integer> next_queue = new HashSet<>();
            for (Integer remainder : queue) {
                for (Integer square : square_nums) {
                    if (remainder.equals(square)) {
                        return level;
                    } else if (remainder < square) {
                        break;
                    } else {
                        next_queue.add(remainder - square);
                    }
                }
            }
            queue = next_queue;
        }
        return level;
    }
}
