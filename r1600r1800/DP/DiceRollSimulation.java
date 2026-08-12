package r1600r1800.DP;

import java.util.Arrays;

//MEMOIZATION
public class DiceRollSimulation {
     int mod=1000000007;
    public int dieSimulator(int n, int[] rollMax) {
        long dp[][][]=new long[n+1][7][16];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=6; j++) Arrays.fill(dp[i][j],-1);
        }
        return (int)work(1,0,0,rollMax,n, dp);
    }
    long work(int i, int prev, int count, int[] rollMax, int n, long[][][] dp){
        if(i==n+1) return 1;
        if(dp[i][prev][count]!=-1) return dp[i][prev][count];
        long sum=0;
        for(int index=1; index<=6; index++){
            if(index==prev){
                if((count+1)<=rollMax[index-1]) sum=(sum+work(i+1,index,count+1,rollMax,n,dp))%mod;
            }
            else sum=(sum+work(i+1,index,1,rollMax,n,dp))%mod;
        }
        return dp[i][prev][count]=sum;
    }
}

/*
TABULATION (3D DP)
class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        int mod=1000000007;
        long dp[][][]=new long[n+1][7][16];
        dp[0][0][0]=1;
        // for(int i=1; i<=6; i++) dp[1][i][1]=1;
        for(int i=1; i<=n; i++){
            for(int current=1; current<=6; current++){
                for(int count=1; count<=rollMax[current-1]; count++){
                        if(count>1) dp[i][current][count]=(dp[i][current][count]+dp[i-1][current][count-1])%mod;
                        else {
                            for(int prev=0; prev<=6; prev++) {
                                if(prev==current) continue;
                                for(int oldcount=0; oldcount<=15; oldcount++) dp[i][current][1]=(dp[i][current][1]+dp[i-1][prev][oldcount])%mod;
                            }
                        }
                    
                }
            }
        }
        long ans=0;
        for(int i=1; i<=6; i++){
            for(int j=0; j<=rollMax[i-1]; j++) ans=(ans+dp[n][i][j])%mod;
        }
        return (int)ans;
    }
}





2D Tabulation
class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        int mod=1000000007;
        long dp[][]=new long[n+1][8];
        dp[0][0]=1;
        dp[0][7]=1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=6; j++){
                dp[i][j]=dp[i-1][7];
                if((i-rollMax[j-1]-1)>=0) dp[i][j]=(dp[i][j]-(dp[i-rollMax[j-1]-1][7]-dp[i-rollMax[j-1]-1][j])+mod)%mod;
                dp[i][7]=(dp[i][7]+dp[i][j])%mod;
            }
        }
        return (int)dp[n][7];
    }
}
*/
