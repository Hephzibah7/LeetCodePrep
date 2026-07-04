/*
3858. Minimum Bitwise OR From Grid
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given a 2D integer array grid of size m x n.

You must select exactly one integer from each row of the grid.

Return an integer denoting the minimum possible bitwise OR of the selected integers from each row.

 

Example 1:

Input: grid = [[1,5],[2,4]]

Output: 3

Explanation:

Choose 1 from the first row and 2 from the second row.
The bitwise OR of 1 | 2 = 3​​​​​​​, which is the minimum possible.
Example 2:

Input: grid = [[3,5],[6,4]]

Output: 5

Explanation:

Choose 5 from the first row and 4 from the second row.
The bitwise OR of 5 | 4 = 5​​​​​​​, which is the minimum possible.
Example 3:

Input: grid = [[7,9,8]]

Output: 7

Explanation:

Choosing 7 gives the minimum bitwise OR.
 

Constraints:

1 <= m == grid.length <= 105
1 <= n == grid[i].length <= 105
m * n <= 105
1 <= grid[i][j] <= 105
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
