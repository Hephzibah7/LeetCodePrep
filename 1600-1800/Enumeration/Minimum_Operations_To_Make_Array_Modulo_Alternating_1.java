/*
https://leetcode.com/problems/minimum-operations-to-make-array-modulo-alternating-i/description/
3937. Minimum Operations to Make Array Modulo Alternating I

You are given an integer array nums and an integer k.

In one operation, you can increase or decrease any element of nums by 1.

An array is called modulo alternating if there exist two distinct integers x and y (0 <= x, y < k) such that:

For every even index i, nums[i] % k == x
For every odd index i, nums[i] % k == y
Return the minimum number of operations required to make nums modulo alternating.

 

Example 1:

Input: nums = [1,4,2,8], k = 3

Output: 2

Explanation:

Let's choose x = 1 for even indices and y = 2 for odd indices.
Perform the following operations:
Increment nums[1] = 4 by 1, giving nums = [1, 5, 2, 8].
Decrement nums[2] = 2 by 1, giving nums = [1, 5, 1, 8].
Now, for even indices, nums[i] % k = 1, and for odd indices, nums[i] % k = 2.
Thus, the total number of operations required is 2.
Example 2:

Input: nums = [1,1,1], k = 3

Output: 1

Explanation:

Incrementing nums[1] by 1 gives nums = [1, 2, 1], which satisfies the condition with x = 1 and y = 2.
Thus, the total number of operations required is 1.
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 109
2 <= k <= 100
 */
public class Minimum_Operations_To_Make_Array_Modulo_Alternating_1 {
    public int minOperations(int[] nums, int k) {
        int n=nums.length;
        long ans=Long.MAX_VALUE;
        for(int i=0; i<k; i++){
            for(int j=0; j<k; j++){
                if(i==j) continue;
                long sum=0;
                long min=Long.MAX_VALUE;
                for(int t=0; t<n; t++){
                    int target=(t%2==0)?i:j;
                    int temp=Math.abs((nums[t]%k)-target);
                    min=Math.min(temp,k-temp);
                    sum+=min;
                }
                ans=Math.min(ans, sum);
            }
        }
        return (int)ans;
    }
}

/*

My Intuition initially-
A-group containing even elements
B-group containing odd elements
xmin1 and xmin2 are the two best minimum values for x
ymin1 and ymin2 are the two best minimum values for y
I found the best first and best second value for both A and B, and if i!=j then return xmin1+ymin2 otherwise xmin1+ymin1,
but there were many cases in which this if condition didnt give right answer, lets take below example-

[1,1,1] k=3

x=1 xmin1=1 xmin2=1=0
y=1 ymin1=1 ymin2=max

in the above case i need to check manually which is suitable ymin2 value. like for what value of y in which sum(abs(nums[i]%k-y)),
and for what value of x in which sum(abs(nums[i]%k-x)), both the sums sum gives me the minmum value.

Correct solution-
Since the constraints are really small, we can afford three loops, and for each x and y value we can calculate the 
min(sum(abs(nums[i]%k-y))+sum(abs(nums[i]%k-x)))
 */
