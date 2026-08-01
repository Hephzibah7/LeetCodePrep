package Contest2ndQuestions;

import java.util.HashMap;

/*
https://leetcode.com/problems/widest-possible-fence/description/
*/
public class WildestPossibleFence {
     public int maximumWidth(int[] planks) {
        int n=planks.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        HashMap<Integer, Integer> res=new HashMap<>();
        for(int i=0; i<n; i++) map.put(planks[i],map.getOrDefault(planks[i],0)+1);
        for(int i=0; i<n; i++) res.put(planks[i],res.getOrDefault(planks[i],0)+1);
        int max=0;
        for(int key:map.keySet()){
            for(int val:map.keySet()){
               if(key==val){
                res.put(key+val, res.getOrDefault((key+val),0)+map.get(key)/2);
               }
               if(key<val){
                res.put(key+val, res.getOrDefault(key+val,0)+Math.min(map.get(key),map.get(val)));
               }
            }
            
        }
        for(int key:res.keySet()) max=Math.max(max,res.get(key));
        return max;
       
    }
}
