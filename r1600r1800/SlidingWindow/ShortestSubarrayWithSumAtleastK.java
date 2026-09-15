class Pair{
    long a;
    int b;
    Pair(long a, int b){
        this.a=a;
        this.b=b;
    }
}
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->Long.compare(x.a,y.a));
        long sum=0;
        int min=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            sum+=nums[i];
            if(sum>=k){
                min=Math.min(min, i+1);
            }
            while(!pq.isEmpty() && sum-pq.peek().a>=k){
                min=Math.min(min, i-pq.poll().b);
            }
            pq.add(new Pair(sum, i));
        }
        if(min==Integer.MAX_VALUE) return -1;
        return min;
    }
}