class Solution {
    private record pair(int a, int b){}
    public int maxEqualAdjacentPairs(int[] nums) {
        int n=nums.length;
        HashMap<Pair,Integer> map=new HashMap<>();
        int count=0;
        for(int i=1; i<n; i++){
            if(nums[i]==nums[i-1]) count++;
            else{
                Pair pair;
                if(nums[i-1]<nums[i]) pair=new Pair(nums[i-1],nums[i]);
                else pair=new Pair(nums[i],nums[i-1]);
                map.put(pair,map.getOrDefault(pair,0)+1);
            }
        }
        int max=0;
        for(Pair key:map.keySet()) max=Math.max(max,map.get(key));
        return max+count;
    }
}