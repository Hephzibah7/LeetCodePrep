/*
https://leetcode.com/problems/k-inverse-pairs-array/
K inverse Pair Array
dp[n][k]=number of different arrays consisting of 0...n numbers and k inverse pairs


dp[n][k]=dp[n-1][k]+dp[n-1][k-2]....dp[n-1][0] <-subproblem

Suppose n=3
1,2,3
So according to fourmulae dp[3][2]=dp[2][0]+dp[2][1]+dp[2][2]

dp[2][2] is not possible
n=3 and k=2  3,1,2   1,2->dp[2][0]
2,3,1->dp[2][1]

Total 2

Base case
dp[0][0]=1
dp[1][0]=1 1,2
dp[2][0]=1 1,2,3

n=1
dp[1][0]=dp[0][0]=1
n=2
dp[2][1]=dp[1][0]+dp[1][1]=1  2,1



Code-
dp[0][0]=1;
for(int i=1; i<=n; i++){
	for(int j=0; j<=k; j++){
		for(int index=0; index<=min(j,n-1); index++) dp[i][j]+=dp[i-1][j-index];
}
}


*/
package r1600r1800.DP;

public class KInversePairsArray {
     public int kInversePairs(int n, int k) {
        int dp[][]=new int[n+1][k+1];
        dp[0][0]=1;
        int mod=1000000007;
        for(int N=1; N<=n; N++){
            for(int K=0; K<=k; K++){
                int ans=0;
                for(int i=0; i<Math.min(K+1,N); i++){
                    ans=(ans+dp[N-1][K-i])%mod;
                }
                dp[N][K]=ans;
            }
        }
        return dp[n][k];
    }
}
