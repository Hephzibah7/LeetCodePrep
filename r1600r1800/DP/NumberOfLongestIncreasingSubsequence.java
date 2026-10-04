class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int ct[]=new int[n];
        Arrays.fill(ct,1);
         int max=1;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j] && dp[i]<=dp[j]){
                    dp[i]=dp[j]+1;
                    ct[i]=ct[j];
                }
                else if(nums[i]>nums[j] && dp[i]==1+dp[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    ct[i]=ct[i]+ct[j];
                }
                max=Math.max(max, dp[i]);
               
            }
        }
        for(int i=0; i<n; i++) System.out.print(ct[i]+" ");
        int count=0;
        for(int i=0; i<n; i++){
            if(dp[i]==max){
                count+=ct[i];
            }
        }
        return count;
        
    }
}