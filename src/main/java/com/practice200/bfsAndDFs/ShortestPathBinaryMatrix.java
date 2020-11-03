package com.practice200.bfsAndDFs;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS
 * [[1,1,0,1],
 *  [1,0,1,0],
 *  [1,1,1,1],
 *  [1,0,1,1]]
 */
public class ShortestPathBinaryMatrix {
    public static void main(String[] args) {

        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= 9) {
            squares.add(square);
            square += diff;
            diff += 2;
        }

        System.out.println(squares);

    }
    public int shortestPathBinaryMatrix(int[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        //搜索的8个方向
        int[][] direction = new int[][]{{1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, -1}, {-1, 1}, {-1, -1}, {-1, 0}};
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair<Integer, Integer>>  queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        while(!queue.isEmpty()){
            int size = queue.size();
            result++;
            while(size-- > 0){
                Pair<Integer, Integer> value = queue.poll();
                int i = value.getKey();
                int j = value.getValue();
                if(grid[i][j] == 1){
                    continue;
                }
                //达到边界处， 直接返回结果
                if(i == m - 1 && j == n - 1){
                    return result;
                }
                grid[i][j] = 1;
                for(int[] dir: direction){
                    int ix = i + dir[0];
                    int jx = j + dir[1];
                    if(ix < 0 || ix > m -1 || jx < 0 || jx > n - 1){
                        continue;
                    }
                    queue.add(new Pair<Integer, Integer>(ix, jx));
                }

            }

        }

        return -1;
    }
}
