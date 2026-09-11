package r1600r1800.DP;

public class HouseRobber {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        int ans=0;
        for(int i=1; i<=n; i++){
            int index=(i-2)>=0?(i-2):0;
           dp[i]=Math.max(dp[i-1],dp[index]+nums[i-1]);
        }
        return dp[n];
        
    }
}
