/*
3882. Minimum XOR Path in a Grid

You are given a 2D integer array grid of size m * n.

You start at the top-left cell (0, 0) and want to reach the bottom-right cell (m - 1, n - 1).

At each step, you may move either right or down.

The cost of a path is defined as the bitwise XOR of all the values in the cells along that path, including the start and end cells.

Return the minimum possible XOR value among all valid paths from (0, 0) to (m - 1, n - 1).

 

Example 1:

Input: grid = [[1,2],[3,4]]

Output: 6

Explanation:

There are two valid paths:

(0, 0) → (0, 1) → (1, 1) with XOR: 1 XOR 2 XOR 4 = 7
(0, 0) → (1, 0) → (1, 1) with XOR: 1 XOR 3 XOR 4 = 6
The minimum XOR value among all valid paths is 6.

Example 2:

Input: grid = [[6,7],[5,8]]

Output: 9

Explanation:

There are two valid paths:

(0, 0) → (0, 1) → (1, 1) with XOR: 6 XOR 7 XOR 8 = 9
(0, 0) → (1, 0) → (1, 1) with XOR: 6 XOR 5 XOR 8 = 11
The minimum XOR value among all valid paths is 9.

Example 3:

Input: grid = [[2,7,5]]

Output: 0

Explanation:

There is only one valid path:

(0, 0) → (0, 1) → (0, 2) with XOR: 2 XOR 7 XOR 5 = 0
The XOR value of this path is 0, which is the minimum possible.

 

Constraints:

1 <= m == grid.length <= 1000
1 <= n == grid[i].length <= 1000
m * n <= 1000
0 <= grid[i][j] <= 1023​
*/
import java.util.*;
public class Minimum_XOR_Path_To_Grid {
    public int minCost(int[][] grid) {
        int dp[][][]=new int[grid.length][grid[0].length][1024];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) Arrays.fill(dp[i][j],-1);
        }
        return work(0,0,0,grid, grid.length, grid[0].length, dp);
    }
    // int work(int i, int j, int val, int[][] grid, int m, int n, int[][][] dp){
    //     if(i==m-1 && j==n-1) return val^grid[m-1][n-1];
    //     if(i<m && j<n && dp[i][j][val]!=-1) return dp[i][j][val];
    //     int ans=Integer.MAX_VALUE;
    //     if(i<m && j<n) ans=Math.min(ans,work(i+1,j,val^grid[i][j],grid,m,n, dp));
    //     if(i<m && j<n) ans=Math.min(ans,work(i,j+1,val^grid[i][j],grid,m,n, dp));
    //     if(i>=m || j>=n) return Integer.MAX_VALUE;
    //     return dp[i][j][val]=ans;
    // }
     int work(int i, int j, int val, int[][] grid, int m, int n, int[][][] dp){
        if(i==m-1 && j==n-1) return val^grid[m-1][n-1];
        if(dp[i][j][val]!=-1) return dp[i][j][val];
        int ans=Integer.MAX_VALUE;
        if(i+1<m) ans=Math.min(ans,work(i+1,j,val^grid[i][j],grid,m,n, dp));
        if(j+1<n) ans=Math.min(ans,work(i,j+1,val^grid[i][j],grid,m,n, dp));
        return dp[i][j][val]=ans;
    }
}
