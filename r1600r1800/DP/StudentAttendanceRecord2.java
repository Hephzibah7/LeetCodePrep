package r1600r1800.DP;

public class StudentAttendanceRecord2 {
     public int checkRecord(int n) {
        long dp[][][]=new long[n+1][2][3];
        dp[0][0][0]=1;
        int mod=1000000007;
        for(int i=1; i<=n; i++){
            for(int counta=0; counta<=1; counta++){
                for(int countl=0; countl<=2; countl++){
                    //adding P
                    dp[i][counta][0]=(dp[i][counta][0]+dp[i-1][counta][countl])%mod;
                    //adding a
                    if(counta>0) dp[i][counta][0]=(dp[i][counta][0]+dp[i-1][counta-1][countl])%mod;
                    //adding l
                    if(countl>0) dp[i][counta][countl]=(dp[i][counta][countl]+dp[i-1][counta][countl-1])%mod;
                }
            }
        }
        long sum=0;
        for(int i=0; i<2; i++){
            for(int j=0; j<3; j++) sum=(sum+dp[n][i][j])%mod;
        }
        return (int)sum;
    }
}
