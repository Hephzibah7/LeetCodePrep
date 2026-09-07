class Pair {
    int position;
    double time;

    Pair(int position, double time) {
        this.position = position;
        this.time = time;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        ArrayList<Pair> data = new ArrayList<>();
        for (int i = 0; i < n; i++)
            data.add(new Pair(position[i], ((double)target-position[i])/speed[i]));
        Collections.sort(data, (a, b) -> Integer.compare(a.position, b.position));
        int res = 0;
        double curr=0;
        for (int i = n - 1; i >= 0; i--) {
            if(data.get(i).time>curr){
                res++;
                curr=data.get(i).time;
            }
           
        }
        return res;
    }
}