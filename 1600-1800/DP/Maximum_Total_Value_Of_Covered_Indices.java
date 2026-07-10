/*
3952. Maximum Total Value of Covered Indices

You are given an integer array nums of length n and a binary string s of length n, where s[i] == '1' means index i initially contains a token and s[i] == '0' means it does not.

You may perform the following operation any number of times:

Choose a token currently located at index i, where i > 0, such that this token has not been moved before.
Move this token from index i to index i - 1.
An index is considered covered if it contains a token after all moves.

Return an integer denoting the maximum total value of nums at the covered indices after optimally performing the operations.

 

Example 1:

Input: nums = [9,2,6,1], s = "0101"

Output: 15

Explanation:

Initially, indices 1 and 3 contain tokens.
Move the token from index 3 to index 2.
Move the token from index 1 to index 0.
The covered indices are [0, 2], so the total value is nums[0] + nums[2] = 9 + 6 = 15.
Example 2:

Input: nums = [5,1,4], s = "001"

Output: 4

Explanation:

Initially, only index 2 contains a token.
It is optimal to leave the token at index 2.
The covered index is [2], so the total value is nums[2] = 4.
Example 3:

Input: nums = [9,3,5], s = "011"

Output: 14

Explanation:

Initially, indices 1 and 2 contain tokens.
Move the token from index 1 to index 0.
The covered indices are [0, 2], so the total value is nums[0] + nums[2] = 9 + 5 = 14.
 

Constraints:

1 <= n == nums.length == s.length <= 105
1 <= nums[i] <= 105
​​​​​​​s[i] is either '0' or '1'
*/

/*
For an index i, the value will only be included in the sum if 
case1-s.charAt(i+1)=='1' or
case2-s.charAt(i)=='1' and check==0

Note- in the case1, no matter whether the current value in the string is 0 or 1, can borrow 1 from i+1 if required
*/
import java.util.Arrays;

public class Maximum_Total_Value_Of_Covered_Indices {
    class Solution {
    public long maxTotal(int[] nums, String s) {
        int n=nums.length;
        long dp[][]=new long[n][2];
        for(int i=0; i<n; i++) Arrays.fill(dp[i],-1);
        return work(0,0,nums,s,dp);
    }
    long work(int i, int check, int[] nums, String s, long[][] dp){
        if(i==nums.length) return 0;
        if(dp[i][check]!=-1) return dp[i][check];
        long max=work(i+1,0,nums,s,dp);
        if(i+1<nums.length  && s.charAt(i+1)=='1') max=Math.max(max, nums[i]+work(i+1,1,nums,s, dp));
        if(s.charAt(i)=='1' && check==0) max=Math.max(max, nums[i]+work(i+1,0,nums,s, dp));
        return dp[i][check]=max;
    }
}
}
