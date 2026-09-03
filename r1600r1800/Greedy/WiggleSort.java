

import java.util.Arrays;
import java.util.HashMap;
/*
sort the array
split into two halves
reverse two halfs
and copy in original array
if length of array is not even
one group will be larger by one 
so suppose 1 indicates larger grp and 2 indicates smaller
so always the first element should be element from the larger group
1 2 1 2 1 2 1 <-like this
If we take first element from the smaller group below problem arises-
2 1 2 1 2 1 1 <-wiggle sort property destroyed

Motto- medians should not end up together
4 5  | 5 6
  |    |    <-starting from here medians end up together so wrong


4 5 | 5 6
|       |  <-starting from here medians can end up together so wrong


4 5 | 5 6
|     |   <-starting from here medians can end up together so wrong

4 5 | 5 6
  |     |  <-starting from here medians can never end up together so right
*/
public class WiggleSort {
    public void wiggleSort(int[] nums) {
      HashMap<Integer,Integer> map=new HashMap<>();
      int n=nums.length;
      for(int i=0; i<n; i++){
        map.put(i,nums[i]);
      }
      Integer[] index = new Integer[nums.length];
      for(int i=0; i<n; i++) index[i]=i;
      Arrays.sort(index,(a,b)->nums[a]-nums[b]);
      int i=(n+2-1)/2-1;
      int j=n-1;
      int k=0;
      while(k<n){
        if(k%2==0 && i>=0) nums[k++]=map.get(index[i--]);
        else nums[k++]=map.get(index[j--]);
       
      }
      
    }
}
