/*
https://leetcode.com/problems/minimum-initial-strength-to-defeat-all-monsters/
Revision required must here

Suppose you are given array of array something like this-
[[1,2,3],[2,3,5]]-> where each array inside represnts range and the value to be added in the range,
in manual manner, you will loop through each array and then loop through each range in that array which will give you a time complexity
of O(n^2), and if you constraints are high will result in tle, so always maintain a difference array,
and then prefix it, to get the correct values in proper index like this-
boosts=[[2,4,7],[0,3,2]]
for first array-[+7,0,0,0,-7,0] 
for second array-[+2,0,+7,0,-2,-7] <-this is called diffrence array
and prefix sum of difference array-[2,2,9,9,7,0]

In the below question we are going or traversing backwards because
if you are standing at index i, if subsequence indexes that is later indexes i+1..., require required energy you add
monsters[i], otherwise if res if equal to 0, you need to add monsters[i]-bonus[i]


Important observation-
Observation 1-
When you see a problem containing something like:

"If your value becomes negative, it becomes 0"

or

"You lose X, but your resource cannot go below zero"

or

"You need enough resource to survive all future operations"

immediately ask yourself:

Can I calculate the minimum resource required backward instead of simulating the resource forward?

Observation 2-
"Apply X to every element from l to r" think about difference array
 */
package Contest3rdQuestions;

public class MinimumInitialStrengthToDefaeatAllMonsters {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n=monsters.length;
        long diff[]=new long[n];
        for(int[] boost:boosts){
            int l=boost[0];
            int r=boost[1];
            int v=boost[2];
            diff[r]+=v;
            if(l>0) diff[l-1]-=v;
        }
        long res=0;
        long bonus=0;
        for(int i=n-1; i>=0; i--){
            bonus+=diff[i];
            if(res>0) res+=monsters[i];
            else res+=Math.max(0L,monsters[i]-bonus);
        }
        return res;
    }
}
