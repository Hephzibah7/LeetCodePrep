import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


class Pair{
    int node;
    long w;
    Pair(int node, long w){
        this.node=node;
        this.w=w;
    }
}

public class Shortest_Path_With_Atnost_K_Consecutive_Characters {
     public int shortestPath(int n, int[][] edges, String labels, int k) {
          long INF = Long.MAX_VALUE / 4;
        ArrayList<ArrayList<Pair>> adjList=new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<Pair>());
        }
        for(int i=0; i<edges.length; i++){
            ArrayList<Pair> temp=adjList.get(edges[i][0]);
            temp.add(new Pair(edges[i][1], edges[i][2]));
        }
        long dist[][]=new long[n][k+1];
        for(int i=0; i<n; i++) Arrays.fill(dist[i],INF);
        PriorityQueue<long[]>pq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0])); //a[0]=cost, a[1]=node,a[2]=count
        dist[0][1]=0;
        pq.add(new long[]{0,0,1});
        while(!pq.isEmpty()){
            long temp[]=pq.remove();
            long cost=temp[0];
            int parent=(int)temp[1];
            int consecutivecount=(int)temp[2];
            if(cost>dist[parent][consecutivecount]) continue;
            for(Pair pair:adjList.get(parent)){
                int currconsecutivecount=0;
                if(labels.charAt(parent)==labels.charAt(pair.node)){
                    if(consecutivecount+1>k) continue;
                    currconsecutivecount=consecutivecount+1;
                }
                else currconsecutivecount=1;
                if(dist[pair.node][currconsecutivecount]>cost+pair.w){
                    dist[pair.node][currconsecutivecount]=cost+pair.w;
                    pq.add(new long[]{dist[pair.node][currconsecutivecount],pair.node,currconsecutivecount});
                }
            }
        }
        long min=INF;
        for(int i=0; i<=k; i++){
            min=Math.min(min, dist[n-1][i]);
        }
        return (int)((min==INF)?-1:min);


    }
}
