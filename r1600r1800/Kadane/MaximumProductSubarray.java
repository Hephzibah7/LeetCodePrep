class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int prod=1;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            prod=prod*nums[i];
            max=Math.max(max, prod);
            if(prod==0) prod=1;
        }
        prod=1;
        for(int i=n-1; i>=0; i--){
             prod=prod*nums[i];
            max=Math.max(max, prod);
            if(prod==0) prod=1;
        }
        return max;
    }
}