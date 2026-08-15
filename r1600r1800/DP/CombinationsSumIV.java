package r1600r1800.DP;

import java.util.Arrays;

public class CombinationsSumIV {
     public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[1001];
        Arrays.fill(dp,-1);
        return work(nums,target, dp);
    }
    int work(int[] nums, int target, int[] dp){
        if(target==0) return 1;
        if(target<0) return 0;
        if(dp[target]!=-1) return dp[target];
        int count=0;
        for(int i=0; i<nums.length; i++){
            count+=work(nums,target-nums[i],dp);
        }
        return dp[target]=count;
    }
}
