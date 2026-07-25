package Google.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EvaluateDivision {
    class Pair{
    int node;
    double w;
    Pair(int node, double w){
        this.node=node;
        this.w=w;
    }
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Integer> map=new HashMap<>();
        int count=0;
        int len=equations.size();
        int n=queries.size();
        for(int i=0; i<len; i++){
            if(!map.containsKey(equations.get(i).get(0))) map.put(equations.get(i).get(0), count++);
            if(!map.containsKey(equations.get(i).get(1))) map.put(equations.get(i).get(1), count++);
        }
        ArrayList<ArrayList<Pair>> edges=new ArrayList<>();
        for(int i=0; i<count; i++) edges.add(new ArrayList<Pair>());
        for(int i=0; i<len; i++){
            int u=map.get(equations.get(i).get(0));
            int v=map.get(equations.get(i).get(1));
            ArrayList<Pair> temp1=edges.get(u);
            temp1.add(new Pair(v,values[i]));
            ArrayList<Pair> temp2=edges.get(v);
            temp2.add(new Pair(u,(double)1/values[i]));
        }
        double ans[]=new double[n];
         for(int i=0; i<n; i++){
            if(!map.containsKey(queries.get(i).get(0)) || !map.containsKey(queries.get(i).get(1))) ans[i]=-1.0;
            else if(queries.get(i).get(0).equals(queries.get(i).get(1))) ans[i]=1.0;
        }
        for(int i=0; i<n; i++){
            if(ans[i]==-1.0 || ans[i]==1.0) continue;
            int u=map.get(queries.get(i).get(0));
            int v=map.get(queries.get(i).get(1));
            int[] visited=new int[count];
            double val=work(u,v,edges, visited);
            ans[i]=val;
        }
        return ans;
    }
    double work(int u, int v, ArrayList<ArrayList<Pair>> edges, int[] visited){
        if(u==v) return (double)1;
        for(Pair pair:edges.get(u)){
            if(visited[pair.node]==1) continue;
            visited[pair.node]=1;
            double temp=work(pair.node,v,edges,visited);
            if(temp!=-1) return temp*pair.w;
            visited[pair.node]=0;
        }
        return (double)-1;

    }
}
}
