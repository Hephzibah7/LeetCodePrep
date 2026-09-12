class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len=tasks.length;
        HashMap<Character,Integer> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0; i<len; i++) map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        for(char key:map.keySet()) pq.add(map.get(key));
        int time=0;
        while(!pq.isEmpty()){
            ArrayList<Integer> remains=new ArrayList<>();
            int cycle=n+1;
            while(!pq.isEmpty() && cycle>0){
                int freq=pq.remove();
                if(freq>1) remains.add(freq-1);
                cycle--;
                time++;
            }
            for(int i=0; i<remains.size(); i++) pq.add(remains.get(i));
            if(pq.isEmpty()) break;
            time+=cycle;
        }
        return time;
    }
}