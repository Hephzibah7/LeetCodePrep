package Contest3rdQuestions;

import java.util.ArrayList;
import java.util.Collections;
/*
7 6 5
8 5 1
wrong output

Prioritizing elements with more capcity is of no use-predict this testcase like above
 */

public class MaximumCapacityWithinBudget {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n=costs.length;
        int m=capacity.length;
        ArrayList<Integer> costlist=new ArrayList<>();
        ArrayList<Integer> capacitylist=new ArrayList<>();
        for(int i=0; i<n; i++) capacitylist.add(capacity[i]);
        ArrayList<Integer> index=new ArrayList<>();
        for(int i=0; i<n; i++) index.add(i);
        Collections.sort(index,(a,b)->{
            return capacitylist.get(b)-capacitylist.get(a);
        });
        for(int i=0; i<n; i++) costlist.add(costs[index.get(i)]);
        capacitylist.sort(Collections.reverseOrder());
        int count=0;
        int sum=0;
        for(int i=0; i<n; i++){
            if(count==2) break;
            if(budget>costlist.get(i)){
                budget-=costlist.get(i);
                count++;
                sum+=capacitylist.get(i);
            }
        }
        return sum;
    
}

/*
Correct solution-
Pattern-Boundary-pointer pattern
This problem makes use of 2 pointers and prefix array
We are using right pointer to find the boundary of a number.
The below pattern is somewhat unusual do revise it
public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n=costs.length;
        ArrayList<Integer> costlist = new ArrayList<>();
        ArrayList<Integer> capacitylist = new ArrayList<>();
        for (int i = 0; i < n; i++)
            costlist.add(costs[i]);
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < n; i++)
            index.add(i);
        Collections.sort(index, (a, b) -> {
            return costlist.get(a) - costlist.get(b);
        });
        for (int i = 0; i < n; i++)
            capacitylist.add(capacity[index.get(i)]);
        Collections.sort(costlist);
        int left = 0;
        int right = n - 1;
        int max = 0;
        System.out.println(costlist);
        System.out.println(capacitylist);
        int prefix[]=new int[n];
        prefix[0]=capacitylist.get(0);
        for(int i=1; i<n; i++) prefix[i]=Math.max(prefix[i-1],capacitylist.get(i));
        while (left < n) {
            if(costlist.get(left)>=budget) break;
            max = Math.max(max, prefix[left]);
            while (right>=0 && (costlist.get(left) + costlist.get(right)) >= budget)
                right--;
            int j=Math.min(left-1,right);
                if(j>=0) max = Math.max(max, capacitylist.get(left) + prefix[j]);
            left++;
        }
        return max;
    }
*/

}
