class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        int[][] jobs=new int[n][3];
        for(int i=0; i<n; i++) {
            jobs[i][0]=startTime[i];
            jobs[i][1]=endTime[i];
            jobs[i][2]=profit[i];
        }
        Arrays.sort(jobs,(a,b)->a[1]-b[1]);
        TreeMap<Integer,Integer> map=new TreeMap<>();
        map.put(0,0);
        for(int i=0; i<n; i++){
            int val=map.floorEntry(jobs[i][0]).getValue()+jobs[i][2];
            if(val>map.lastEntry().getValue()) map.put(jobs[i][1],val);
        }
        return map.lastEntry().getValue();
    }
}