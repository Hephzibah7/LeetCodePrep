/*
https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/

Bottom up or tabulation

At position i,
we have two options
1) The new element updates the current maximum and becomes new maximum
2)The new element does not update the current maximum which means the new element is less than j, if j is the current maximum

 public int numOfArrays(int n, int m, int k) {
        int mod=1000000007;
        long dp[][][]=new long[n+1][m+1][k+1];
        
        //base case
        for(int i=1; i<=m; i++) dp[1][i][1]=1;

        for(int i=2; i<=n; i++){
            for(int j=1; j<=m; j++){
                for(int t=1; t<=k; t++){

                    dp[i][j][t]=(dp[i][j][t]+(1L*j*dp[i-1][j][t])%mod)%mod;

                    for(int x=1; x<j; x++) dp[i][j][t]=(dp[i][j][t]+dp[i-1][x][t-1])%mod;
                }
            }
        }
       long ans=0;
       for(int j=1; j<=m; j++) ans=(ans+dp[n][j][k])%mod;
       return (int)ans;
    }
 */
package r1600r1800.DP;

import java.util.Arrays;

//top-down approach
public class BuildArrayWhereYouCanFindExactlyKComparisons {
    int mod=1000000007;
    public int numOfArrays(int n, int m, int k) {
        long dp[][][]=new long[n+1][k+1][m+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=k; j++) Arrays.fill(dp[i][j],-1);
        }
        return (int)work(0,0,0,n,m,k,dp);
    }

    long work(int i, int cost, int lastmax, int n, int m, int k, long[][][] dp) {
        if (i == n) {
            if (cost == k)
                return 1;
            else
                return 0;
        }
        if (i > n)
            return 0;
        if (cost > k)
            return 0;
            if(dp[i][cost][lastmax]!=-1) return dp[i][cost][lastmax];
        long count = 0;
        for (int j = 1; j <= m; j++) {
            if (lastmax < j)
                count = (count + work(i + 1, cost + 1, j, n, m, k, dp))%mod;
            else
                count = (count + work(i + 1, cost, lastmax, n, m, k, dp))%mod;
        }
        return dp[i][cost][lastmax]=count;
    }

}
