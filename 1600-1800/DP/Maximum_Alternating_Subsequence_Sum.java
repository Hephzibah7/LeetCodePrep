/*
https://leetcode.com/problems/maximum-alternating-subsequence-sum/
*/
public class Maximum_Alternating_Subsequence_Sum {
     public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long odd=0;
        long even=0;
        for(int i=0; i<n; i++){
            even=Math.max(even, odd+nums[i]);
            odd=even-nums[i];
        }
        return even;
    }
}
