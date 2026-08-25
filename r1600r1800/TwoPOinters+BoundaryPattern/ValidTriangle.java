package r1600r1800.TwoPOinters+BoundaryPattern;

public class ValidTriangle {
    /*
    Valid Triangle means if you added length of any 2 side it will be greater than 3rd side length
    */
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=0;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                int k=n-1;
                while(k>j && (nums[i]+nums[j])<=nums[k]) k--;
                if(k>j) ans+=k-j;
            }
        }
        return ans;
    }
}
