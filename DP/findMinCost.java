package DP;
import java.util.*;

public class findMinCost {
    
    /*
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, 
     * which minimizes the sum of all numbers along its path.
     * Note: You can only move either down or right at any point in time.
     * 
     * Using 2D - DP: solve from bottom-up.
     * Since we can only move down or right. 
     * 
     * dp[i][j]物理意义：the min cost from grid[0][0] 到grid[i][j]
     * base case:
     * dp[0][0] = grid[0][0]
     * dp rule:
     * 
     * dp[i][j] = min(up, left) + grid[i][j]
     * result: dp[grid.length - 1][grid[0].length-1]
     * 
     * 填表：从左到右，从上到下
     * 
     * eg.
     * 1 3 1
     * 1 5 1  
     * 4 2 1
     * [[1,3,1],[1,5,1], [4,2,1]] i = row, j = col
     * 1    1+1    2+3
     * 1+1  2+5    5+1
     * 2+4  6+2    6+1 = 7
     * cost = 1+3+1+1 +1=7 
     */
    public int minCost(int[][] grid) {
        // conner
        if(grid == null || grid.length == 0) return 0;
        if(grid.length == 1 && grid[0].length == 1) return 0;
        // construct DP arr
        int[][] dp = new int[grid.length][grid[0].length];
        // fill-in table
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(i == 0 && j == 0){
                    // base case
                    dp[i][j] = grid[0][0];
                }
                else if(i == 0){
                    // at first row
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }
                else if(j == 0){
                    // at first column
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
                else{
                    // at [i][j]
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
        
    }


}
