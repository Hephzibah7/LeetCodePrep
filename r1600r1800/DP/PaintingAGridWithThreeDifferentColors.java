/*
https://leetcode.com/problems/painting-a-grid-with-three-different-colors/

Since there can be total 5000 cells, if you see the constraints, so there can be 3^5000 ways to color an m*n grid,
to track each of em in order to obey the constraints in impractical and will give tle, so we will work smartly.
Since clearly it can be noticed that the number of rows can be maximum 5, so its small.
We can represent a specific color colbination of a column in base 3, since there can be 3 different colors.
suppose our m=2, so total length is 3^2=9,
Meaning?
It means that there are total 9 ways to color an array of 2.
GG,GB,GR,RR,RB,RG,BR,BB,BG ->9 ways
And each of the ways can be represented using numbers,
and each numbers can be written as in terms of base 3.

A number n can be written as in terms of base 3,
n=a0+a1*3^1+a2*3^2... 
n=a0+3(a1+3a2...) is in the form n=r+qd,
where r=a0 is the remainder when the number is divided by 3,
r can be 0,1,2-> so 0->R, 1->B, 2->G, each remainder represents a color.
a0=n%3, <-thus when moduling n with 3 for the first time you get first constant or the first color.
Now n=Math.floor(q/3)->(a1+3(a2+a3*3^1...))
Now when you again mod with new n, the r=a1, thus you get the second color.
0->0*3^0+0*3^1=(RR)
1->1*3^0+0*3^1=(BR)
2->2*3^0+0*3^1=(GR)...thus you can represent till 8.

Step 1->Find all valid columns and add in the list.
Step 2->Find all compatible columns and store it in the map
Step 2->Traverse through each column now 1 to n, and for each column, loop the valid column
      that is for each valid pattern or column, nextdp[pattern1]=nextdp[pattern1]+dp[pattern2]
        suppose there is 3 ways to reach state 1, or 3 columns are compatible to be put before column i of state 1,
       so dp[1]=way1+way2+way3
*/
package r1600r1800.DP;

import java.util.ArrayList;
import java.util.HashMap;

public class PaintingAGridWithThreeDifferentColors {
    public int colorTheGrid(int m, int n) {
        int len=(int)(Math.pow(3,m));
        int mod=1000000007;
        int dp[]=new int[len]; //possible patterns in a column that is len possible patterns
        ArrayList<Integer> validColumns=new ArrayList<>();
        for(int i=0; i<len; i++){
            if(validCol(i,m)) {
                validColumns.add(i);
                dp[i]=1;
            }
        }
       
        HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
        for(int col:validColumns) map.put(col,new ArrayList<>());
        //check which columns are compatible to each other, which means col1[0] should not be equal to col2[0]
        for(int col1:validColumns){
            for(int col2:validColumns){
                if(isCompatible(col1,col2,m)){
                    ArrayList<Integer> temp=map.get(col1);
                    temp.add(col2);
                }
            }
        }
       
        for(int col=1; col<n; col++){
            int nextdp[]=new int[len];
            for(int pattern1:validColumns){
                for(int pattern2:map.get(pattern1)){
                    nextdp[pattern1]=(nextdp[pattern1]+dp[pattern2])%mod;
                }
               
            }
           
            dp=nextdp;
        }

        int sum=0;
        for(int i=0; i<len; i++) sum=(sum+dp[i])%mod;
        return sum;


    }
    //Check whether this particuar pattern is valid or not, that is it shouldn't have adjacent same color
    boolean validCol(int col, int m){
        int previous=-1;
        for(int row=0; row<m; row++){
            int mod=col%3;
            if(previous==mod) return false;
            previous=mod;
            col=col/3;
        }
        return true;
    }

    //check whether two columns are compatible which means the adjacent rows should not be equal
    boolean isCompatible(int col1, int col2, int m){
        for(int row=0; row<m; row++){
            if((col1%3)==(col2%3)) return false;
            col1=col1/3;
            col2=col2/3;
        }
        return true;
    }
}
