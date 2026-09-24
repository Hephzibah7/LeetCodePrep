class Solution {
    public int superEggDrop(int k, int n) {
        int dp[][]=new int[k+1][n+1];
        for(int i=0; i<=k; i++) Arrays.fill(dp[i],-1);
        return work(k,n,dp);
    }
    int work(int k, int n,int[][] dp){
        if(n==0 || n==1) return n;
        if(k==1) return n;
        if(dp[k][n]!=-1) return dp[k][n];
        int min=1000000;
        int l=1;
        int r=n;
        while(l<=r){
            int mid=(l+r)/2;
            int left=work(k-1,mid-1, dp);
            int right=work(k,n-mid, dp);
            min=Math.min(min,1+Math.max(left,right));
            if(left<right) l=mid+1;
            else r=mid-1;

        }
        return dp[k][n]=min;

    }
}