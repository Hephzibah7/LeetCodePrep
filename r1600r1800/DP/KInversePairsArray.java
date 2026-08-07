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
