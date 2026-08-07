/*
https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/
 */
package r1600r1800.DP;

public class NumberOfWaysToPaintNmultipliedby3Grid {
     public int numOfWays(int n) {
        int mod=1000000007;
        long[][] dp=new long[n][2];
        dp[0][0]=6;
        dp[0][1]=6;
        for(int i=1; i<n; i++){
            for(int j=0; j<2; j++){
                if(j==0) dp[i][j]=((1L*dp[i-1][0]*3)%mod+(1L*dp[i-1][1]*2)%mod)%mod;
                else dp[i][j]=((1L*dp[i-1][0]*2)%mod+(1L*dp[i-1][1]*2)%mod)%mod;
            }
        }
        long sum=0;
        for(int i=0; i<2; i++) sum=(sum+dp[n-1][i])%mod;
        return (int)sum;
    }
}
