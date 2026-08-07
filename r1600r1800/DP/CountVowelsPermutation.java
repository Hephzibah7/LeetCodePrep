/*
https://leetcode.com/problems/count-vowels-permutation/
*/

package r1600r1800.DP;

import java.util.HashMap;

public class CountVowelsPermutation {
     public int countVowelPermutation(int n) {
        long dp[][]=new long[n][5];
        HashMap<Character, Integer> map=new HashMap<>();
        map.put('a',0);
        map.put('e',1);
        map.put('i',2);
        map.put('o',3);
        map.put('u',4);
        int mod=1000000007;
        for(int i=0; i<5; i++) dp[0][i]=1;
        for(int i=1; i<n; i++){
            for(int j=0; j<5; j++){
                if(j==0) dp[i][j]=(dp[i-1][map.get('e')]+dp[i-1][map.get('u')]+dp[i-1][map.get('i')])%mod;
                if(j==1) dp[i][j]=(dp[i-1][map.get('a')]+dp[i-1][map.get('i')])%mod;
                if(j==2) dp[i][j]=(dp[i-1][map.get('e')]+dp[i-1][map.get('o')])%mod;
                if(j==3) dp[i][j]=(dp[i-1][map.get('i')])%mod;
                if(j==4) dp[i][j]=(dp[i-1][map.get('o')]+dp[i-1][map.get('i')])%mod;
            }
        }
        long sum=0;
        for(int i=0; i<5; i++) sum=(sum+dp[n-1][i])%mod;
        return (int)sum;


    }
}
