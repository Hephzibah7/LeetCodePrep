class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0; i<nums.length; i++) sum+=nums[i];
        if(sum%2!=0) return false;
        int dp[][]=new int[nums.length][sum+1];
        for(int i=0; i<nums.length; i++) Arrays.fill(dp[i],-1);
        return (work(0, sum/2, nums, dp)==1?true:false);
    }
    int work(int i, int sum, int[] nums, int[][] dp){
        if(i>=nums.length){
            if(sum==0) return 1;
            return 0;
        }
        if(sum<0) return 0;
        if(dp[i][sum]!=-1) return dp[i][sum];
        return dp[i][sum]=((work(i+1,sum-nums[i],nums, dp)==1)||(work(i+1,sum,nums, dp)==1))==true?1:0;
    }
}