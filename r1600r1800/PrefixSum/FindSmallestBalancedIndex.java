
/*
https://leetcode.com/problems/find-the-smallest-balanced-index/submissions/1957228488/
*/

/*
Simple prefix problem but the real issue in this to handle the overflowing due to the product of the numbers,
how would you check whether the current sum==product without product being overflowed which means
product=product*nums[i+1] in the code right?
what if in this code the product overflowed then the correct value will not be checked in the sum==product right?

so we will check if(sum/nums[i]<product) break; that if it dosent return false, it will break, in this we are doing the same thing
instaed of multiplying the product with the nums[i], we are dividing it with the sum, to prevent the overflow and to check the
condition,

 if(sum<product) break; //optimization
 as we know, we are traversing from right to left, the sum decresses and the product increases, if at any i,
 the sum decreses then the current value ofproducr there is not use of traversing any further
*/
public class FindSmallestBalancedIndex {
    public int smallestBalancedIndex(int[] nums) {
        int n=nums.length;
        long sum=0;
        long product=1;
        for(int i=0; i<n; i++) sum+=nums[i];
        for(int i=n-1; i>=0; i--){
            if(i<n-1) product=1L*product*nums[i+1];
            sum-=nums[i];
            if(sum<product) break; //optimization
            if(sum==product) return i;
            if(sum/nums[i]<product) break;
        }
        return -1;
        

    }
}
