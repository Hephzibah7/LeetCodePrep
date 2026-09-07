class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums2.length;
        int ans[]=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=n-1; i>=0; i--){
           while(!stack.isEmpty() && stack.peek()<nums2[i]) stack.pop();
           if(stack.isEmpty()) ans[i]=-1;
           else ans[i]=stack.peek();
           stack.push(nums2[i]);
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0; i<n; i++) map.put(nums2[i],ans[i]);
        int m=nums1.length;
        int res[]=new int[m];
        for(int i=0; i<m; i++) res[i]=map.get(nums1[i]);
        return res;

    }
}