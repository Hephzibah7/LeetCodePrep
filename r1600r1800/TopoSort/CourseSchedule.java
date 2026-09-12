class Solution {
    public boolean canFinish(int numCourses, int[][] arr) {
        int n=arr.length;
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        for(int i=0; i<numCourses; i++) adjList.add(new ArrayList<>());
        for(int i=0; i<n; i++){
            ArrayList<Integer> list=adjList.get(arr[i][1]);
            list.add(arr[i][0]);
        }
        int indegrees[]=new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int next:adjList.get(i)){
                indegrees[next]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(indegrees[i]==0) q.add(i);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int val=q.remove();
            ans.add(val);
            for(int next:adjList.get(val)){
                indegrees[next]--;
                if(indegrees[next]==0) q.add(next);
            }
        }
        return (ans.size()==numCourses)?true:false;
       

    }
}