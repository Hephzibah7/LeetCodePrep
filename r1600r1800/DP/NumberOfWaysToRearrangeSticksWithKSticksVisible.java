/*
https://leetcode.com/problems/number-of-ways-to-rearrange-sticks-with-k-sticks-visible/
DP Pattern-two options to pick
Two options to pick-
Tallest stick-If you are picking tallest stick the subproblem is reduced to dp(n-1,k-1)
smaller than tallest stick-If you are picking rest of the (n-1) options, then the subproblem is reduced to dp(n-1,k),
because now from rest of the numbers you need to make k sticks visible.

Here we are traversing from right to left in order to reduce complexity
dp[n][k]=number of ways to arrange n sticks with k sticks visible
mind it n is not here the permuatation, but the number of sticks available
 */
package r1600r1800.DP;
import java.util.Arrays;

public class NumberOfWaysToRearrangeSticksWithKSticksVisible {
      int mod=1000000007;
    public int rearrangeSticks(int n, int k) {
        long[][] dp=new long[n+1][k+1];
        for(int i=0; i<=n; i++) Arrays.fill(dp[i],-1);
        return (int)(work(n,k,dp)%mod);
    }
    long work(int n, int k, long[][] dp){
        if(k==0 || k>n) return 0;
        if(n<=1) return 1;
        if(dp[n][k]!=-1) return dp[n][k];
        long ans=0;
        ans=(ans+work(n-1,k-1,dp))%mod;
        ans=(ans+(1L*(n-1)*work(n-1,k,dp)))%mod;
        return dp[n][k]=ans;
    }
}
