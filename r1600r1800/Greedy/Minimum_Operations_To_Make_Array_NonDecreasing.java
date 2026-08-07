//link- https://leetcode.com/problems/minimum-operations-to-make-array-non-decreasing/description/
/*

3914. Minimum Operations to Make Array Non Decreasing
You are given an integer array nums of length n.

In one operation, you may choose any subarray nums[l..r] and increase each element in that subarray by x, where x is any positive integer.

Return the minimum possible sum of the values of x across all operations required to make the array non-decreasing.

An array is non-decreasing if nums[i] <= nums[i + 1] for all 0 <= i < n - 1.

 

Example 1:

Input: nums = [3,3,2,1]

Output: 2

Explanation:

One optimal set of operations:

Choose subarray [2..3] and add x = 1 resulting in [3, 3, 3, 2]
Choose subarray [3..3] and add x = 1 resulting in [3, 3, 3, 3]
The array becomes non-decreasing, and the total sum of chosen x values is 1 + 1 = 2.

Example 2:

Input: nums = [5,1,2,3]

Output: 4

Explanation:

One optimal set of operations:

Choose subarray [1..3] and add x = 4 resulting in [5, 5, 6, 7]
The array becomes non-decreasing, and the total sum of chosen x values is 4.

 

Constraints:

1 <= n == nums.length <= 105
1 <= nums[i] <= 109

 */



public class Minimum_Operations_To_Make_Array_NonDecreasing{
    long work(int[] nums){
        int n=nums.length;
        long ans=0;
        for(int i=1; i<n; i++){
            ans+=Math.max(0,nums[i-1]-nums[i]);
        }
        return ans;
    }
   public static void main(String[] args) {
     
   }
}

/*

8 4 3 2 1- observe to make all elements equal to the largest number we have to add -
step 1 8-4=4 points to second element turning 4 to 8
step 2 4-3=1 points to third element turning 3 to 4
step 3 3-2=1 to fourth element turning 2 to 3
step 4 2-1=1 points to last turning 1 to 2,
so basically in step 4  when 8 4 3 2 2 (x=1)-> 8 4 3 3 3 (x=1) -> 8 4 4 4 4 (x=1) ->
8 8 8 8 8 (x=4) 
Ans=4+1+1+1=7 or (largest element-smallest element in every decreasing subarray) (intuitive right?)
so if (nums[i]>nums[i+1]), then to make it same we add nums[i]-nums[i+1] points to
nums[i+1] element.

lets take this example-
8 4 3 2 9 2 1 -> (8 4 3 2) (decresing subarray) (9 2 1) (another decreasing subarray)
8-2+9-1=6+8=14

or you can do 

8-4+4-3+3-2+9-2+2-1 this gives the same answer

because,

In 8 4 3 2 1 or any decreasing subarray

8-1 is equal to (8-4)+(4-3)+(3-2)+(2-1)

And hence the above algo works

 */