package r1600r1800.DP;

public class MinimumDaysToSvoreExactlyNPoints {
    
}
class Solution {
    public int minDays(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        int val=1;
        int k=1;
        while(val<=n){
            dp[val]=k;
            for(int i=val+1; i<=Math.min(n,val+val); i++){
                dp[i]=Math.min(dp[i],k+1+dp[i-val]);
            }
            k++;
            val+=k;
        }
        return dp[n];
    }
}