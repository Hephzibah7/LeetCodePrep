/*
https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/
 */
package r1600r1800.DP;

import java.util.Arrays;

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
