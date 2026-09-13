//Simple Dijkstra algo
class Pair{
    int b;
    int w;
    Pair(int b, int w){
        this.b=b;
        this.w=w;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adjList=new ArrayList<>();
        for(int i=0; i<=n; i++) adjList.add(new ArrayList<>());
        for(int i=0; i<times.length; i++){
            ArrayList<Pair> temp=adjList.get(times[i][0]);
            temp.add(new Pair(times[i][1],times[i][2]));
        }
        
        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->(a.w-b.w));
        q.add(new Pair(k,0));
        dist[k]=0;
        while(!q.isEmpty()){
            Pair node=q.remove();
            for(Pair child:adjList.get(node.b)){
                if(dist[child.b]>(node.w+child.w)){
                    dist[child.b]=node.w+child.w;
                    q.add(new Pair(child.b,node.w+child.w));
                }
            }
        }
        int count=0;
        int max=0;
        for(int i=0; i<=n; i++) System.out.print(dist[i]+" ");
        for(int i=1; i<=n; i++){
            if(dist[i]!=Integer.MAX_VALUE) count++;
            max=Math.max(max, dist[i]);
        }
        if(count<n) return -1;
        return max;

    }
}