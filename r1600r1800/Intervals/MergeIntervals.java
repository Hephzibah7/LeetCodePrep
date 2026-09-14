class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
       Arrays.sort(intervals,(a,b)->a[0]-b[0]); 
       int start=intervals[0][0];
       int end=intervals[0][1];
       ArrayList<int[]> list=new ArrayList<>();
       for(int i=1; i<n; i++){
        if(intervals[i][0]<=end){
           end=Math.max(end, intervals[i][1]); 
        }
        else{
            list.add(new int[]{start,end});
            start=intervals[i][0];
            end=intervals[i][1];
        }
       }
        list.add(new int[]{start,end});
        int ans[][]=new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            ans[i][0]=list.get(i)[0];
            ans[i][1]=list.get(i)[1];
        }
        return ans;
    }
}