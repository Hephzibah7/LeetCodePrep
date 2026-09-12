package r1600r1800.BinarySearch;
/*
In the binary search for "Split Array Largest Sum" (LeetCode 410), checking for less than or equal to
 \(k\) works because any valid split into fewer than 
\(k\) subarrays can always be safely re-split into exactly \(k\) subarrays without increasing the maximum subarray sum
*/
public class SplitArrayLargestSum {
     public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int max=0;
        int sum=0;
        for(int i=0; i<n; i++) {
            sum+=nums[i];
            max=Math.max(max,nums[i]);
        }
        int low=max;
        int high=sum;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            int temp=work(nums,mid);
            if(temp<=k){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    int work(int[] arr, int limit){
        int n=arr.length;
        int ans=1;
        int sum=0;
        for(int i=0; i<n; i++){
            if(arr[i]+sum<=limit) sum+=arr[i];
            else{
                ans++;
                sum=arr[i];
            }
        }
        return ans;

    }
}
