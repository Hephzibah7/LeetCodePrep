/*
https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/
So,
when n=1
Two possible combinations- P1 D1, D1 P1
Total combinations=2
Total Number of combinations=No of valid pairs+No of invalid pairs
Point to observe-Every invalid pair has its corresponding valid pair like below-
D1 P1-> this is invalid swap D1 P1 you get valid pair
so number of valid pair=total pair/2
Algorithm-
all arrangements of n=1->find valid arrangements->add n=2->find valid arrangements
So when n=2
P1 D1 <-valid arrangement only
to put P2 we have total three choices -> _P1_D1_
after adding P2 in any of this choice suppose -> P2 P1 D1
we have 4 choices for D2-> _P2_P1_D1_D2_
So deriving the formula-
It goes as follows
To put P2, when n=2 we have 2(n-1)+1 choices->can be written as 2n-1
To put D2, when n=2 we have 2n choices
Total=(2n-1)*(2n) choices
Generalizing it,
We took here only 1 valid arrangement when n=1
but there can be x valid arrangement when n-1
so now for n,
Total combinations (valid combinations+invalid combinations)
=(2n-1)*(2n)*x where x is the number of valid combinations when n=n-1;
Now after getting total combinations,
Valid combinations=total/2
i.e ((2n-1)*2n*x)/2 or ((2n-1)*n*x)





 */
package r1600r1800.DP;

public class CountAllValidPicukUpAndDeliveryOptions {
    public int countOrders(int n) {
        int mod=1000000007;
        long res=1L;
        for(int i=2; i<=n; i++){
            long first=(1L*2*i-1)%mod;
            long second=(1L*i)%mod;
            res=(1L*res*(1L*first*second)%mod)%mod;
        }
        return (int)res;
    }
}
