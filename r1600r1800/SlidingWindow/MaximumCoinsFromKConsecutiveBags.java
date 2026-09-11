package r1600r1800.SlidingWindow;

import java.util.Arrays;

public class MaximumCoinsFromKConsecutiveBags {
    public long maximumCoins(int[][] arr, int k) {
        int n=arr.length;
        long max=0;
        long curr=0;
        long part=0;
        Arrays.sort(arr, (a,b)->a[0]-b[0]);
        for(int i=0, j=0; i<n; i++){
            while(j<n && arr[j][1]<=arr[i][0]+k-1){
                curr+=1L*(arr[j][1]-arr[j][0]+1)*arr[j][2];
                j++;
            }
            if(j<n) {
                part=1L*Math.max(0,arr[i][0]+k-1-arr[j][0]+1)*arr[j][2];
            max=Math.max(max,curr+part);
            }
            curr-=1L*(arr[i][1]-arr[i][0]+1)*arr[i][2];
        }
        curr=0;
        for(int i=0, j=0; i<n; i++){
            curr+=1L*(arr[i][1]-arr[i][0]+1)*arr[i][2];
            while(arr[j][1]<arr[i][1]-k+1){
                curr-=1L*(arr[j][1]-arr[j][0]+1)*arr[j][2];
                j++;
            }
             part=1L*Math.max(0,arr[i][1]-k+1-arr[j][0])*arr[j][2];
            max=Math.max(max,curr-part);
        }
        return max;
    }
}
