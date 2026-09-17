class Pair{
    long a;
    long b;
    Pair(long a,long b){
        this.a=a;
        this.b=b;a
    }
}
class Solution {
    public long shadowPairs(int[] nums) {
        int n=nums.length;
        Stack<Pair> stack=new Stack<>();
        int i=0;
        long count=0;
        long temp=0;
        while(i<n){
            while(!stack.isEmpty() && stack.peek().a>nums[i]) {
                temp-=stack.pop().b;
            }
            if(!stack.isEmpty() && stack.peek().a==nums[i]){
                Pair pair=stack.pop();
                if(!stack.isEmpty()) count+=temp-pair.b;
                stack.push(new Pair(nums[i],pair.b+1));
                temp++;
            }
            else{
                if(!stack.isEmpty()) count+=temp;
                stack.push(new Pair(nums[i],1));
                temp++;
            }
            i++;
        }
        return count;
    }
}