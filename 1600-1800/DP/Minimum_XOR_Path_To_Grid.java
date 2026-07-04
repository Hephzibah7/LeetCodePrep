
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
