
/*
https://leetcode.com/contest/weekly-contest-510/problems/minimum-total-cost-to-process-all-elements/
*/

/*
In this question, the answer is quite easy but the real problem is too deal with large numbers, we have to make sure that the numbers
or values are in the range within 10^9+7,
this coding problem requires us to find the sum till temp that is if temp=5, we need the sum of first 5 natural numbers,
which can be calculated using formulae sum=n*(n+1)/2,
the problem is not n can go till 10^9, so multiplying 10^9*10^9, surpsasses the long limit, thus throwing errors,
to deal with this we can either store first=n and second=n+1,
mod them to bring to range that is first=n mod m , second=n mod m,
ans=(first*second) mod m,
and then ans=ans/2,
this is wrong, why?
in arithmetic we do not perform divison after modulation, diviion of a number wrt to divisor happens when the number is multiple of 
divisor, when we mod, it looses its orginal magnitude and comes in the form of remander in the range (0...m-1),
first=27 second=2 first*second=54 mod=4, 54%4=2 2/2=1 (mod than division)
54/2=17, 17mod 4=1 (division than mod)
but in the case of addition, multiplication, substraction we can perform this operation after mod, this gives the same result,
In a 12-hour clock, if at 10:00am if you add 24hrs you get 10:00am again,
how did you do that 24%24=0 10:00+0=10:00 or 10:00+24=34&24=10:00 gives the same result

*/
public class MinimumTotalCostToProcessAllElements {
    public int minimumCost(int[] nums, int k) {
        int mod=1000000007;
        int n=nums.length;
        long sum=-k;
        for(int i=0; i<n; i++) sum+=nums[i];
         long temp = (long)Math.ceil((double)sum/k);
        long first=temp;
        long second=temp+1;
        if(first%2==0) first=first/2;
        else second=second/2;
        first%=mod;
        second%=mod;
        long ans=(first*second)%mod;
        //  ans=ans/2;
        //in arithmetic you cannot perfom division after modulation since it gives wrong answer
        //first=27 second=2 first*second=54 mod=4, 54%4=2 2/2=1 (mod than division)
        //54/2=17, 17mod 4=1 (division than mod)
        return (int)(ans);
    }
}

