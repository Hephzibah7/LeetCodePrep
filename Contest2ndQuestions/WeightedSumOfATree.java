package Contest2ndQuestions;

public class WeightedSumOfATree {
    public long weightedSum(int[] parent, int[] nums) {
        int n=nums.length;
        long depth[]=new long[n];
        long ans=0;
        long height=0;
        depth[0]=1;
        for(int i=0; i<n; i++){
            if(depth[i]==0) calcDepth(i,parent,depth);
            height=Math.max(height,depth[i]);
        }
        for(int i=0; i<n; i++){
             ans+=1L*nums[i]*(height-depth[i]+1);
        }
        return ans;
    }
    long calcDepth(int node, int[] parent, long[] depth){
        if(depth[node]!=0) return depth[node];
        depth[node]=1+calcDepth(parent[node],parent,depth);
        return depth[node];
    }
}
