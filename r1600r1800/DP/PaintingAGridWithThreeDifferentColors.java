/*
https://leetcode.com/problems/painting-a-grid-with-three-different-colors/
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
