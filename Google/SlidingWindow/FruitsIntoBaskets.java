/*
simple problem
https://leetcode.com/problems/fruit-into-baskets/
*/
package Google.SlidingWindow;

public class FruitsIntoBaskets {
     public int totalFruit(int[] fruits) {
        int n=fruits.length;
        int f1=-1;
        int f2=-1;
        int count1=0;
        int count2=0;
        int count=0;
        int start=0;
        int end=0;
        int max=0;
        while(end<n){
            while(start<=end && f1!=-1 && f2!=-1 && fruits[end]!=f1 && fruits[end]!=f2){
                if(fruits[start]==f1) count1--;
                else count2--;
                if(count1==0) f1=-1;
                if(count2==0) f2=-1;
                start++;
            }
            if(f1==-1){
                f1=fruits[end];
                count1=1;
            }
            else if(f1==fruits[end]){
                count1++;
            }
            else if(f2==-1){
                f2=fruits[end];
                count2=1;
            } 
            else if(f2==fruits[end]){
                count2++;
            }
            max=Math.max(max, count1+count2);
            end++;
        }
        return max;
    }

}
