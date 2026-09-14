class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int len=meetings.length;
        PriorityQueue<Integer> free=new PriorityQueue<>();
        PriorityQueue<long[]> busy=new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]) return Long.compare(a[0],b[0]);
            return Long.compare(a[1],b[1]);
        });
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        for(int i=0; i<n; i++) free.add(i);
        int temp[]=new int[n];
        for(int i=0; i<len; i++){
            int start=meetings[i][0];
            int end=meetings[i][1];
            while(!busy.isEmpty() && busy.peek()[1]<=start){
                free.add((int)busy.remove()[0]);
            }
            if(!free.isEmpty()){
                int index=free.remove();
                busy.add(new long[]{index,end});
                temp[index]++;
            }
            else{
                long arr[]=busy.remove();
                long endTime=arr[1]+(end-start);
                busy.add(new long[]{arr[0],endTime});
                temp[(int)arr[0]]++;
            }
        }
        int index=0;
        int max=0;
        for(int i=0; i<n; i++){
            if(temp[i]>max){
                max=temp[i];
                index=i;
            }
        }
        return index;
    }
}