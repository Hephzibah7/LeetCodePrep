/*
You are given an integer array nums of length n.

Alice and Bob are playing a game. Alice chooses:

An integer k such that k > 1.
Two integers l and r such that 0 <= l <= r < n.
Initially, both Alice's and Bob's scores are 0.

For each index i in the range [l, r] (inclusive):

If nums[i] is divisible by k, Alice's score increases by nums[i].
Otherwise, Bob's score increases by nums[i].
The score difference is Alice's score minus Bob's score.

Alice wants to maximize the score difference. If there are multiple values of k that achieve the maximum score difference, she chooses the smallest such k.

Return the product of the maximum score difference and the chosen value of k. Since the result can be large, return it modulo 109 + 7.

 

Example 1:

Input: nums = [1,4,6,8]

Output: 36

Explanation:

Alice can choose k = 2, l = 1, and r = 3.
All values in nums[1..3] are divisible by 2, so Alice's score is 4 + 6 + 8 = 18, while Bob's score is 0.
The score difference is 18, which is the maximum possible. Among all values of k that achieve this score difference, the smallest is 2.
Therefore, the answer is 18 * 2 = 36.
Example 2:

Input: nums = [2,1,2]

Output: 6

Explanation:

Alice can choose k = 2, l = 0, and r = 2.
The values nums[0] and nums[2] are divisible by 2, so Alice's score is 2 + 2 = 4. The value nums[1] is not divisible by 2, so Bob's score is 1.
The score difference is 4 - 1 = 3, which is the maximum possible. Among all values of k that achieve this score difference, the smallest is 2.
Therefore, the answer is 3 * 2 = 6.
Example 3:

Input: nums = [1]

Output: 1000000005

Explanation:

Alice must choose some k > 1. The smallest possible choice is k = 2.
Since nums[0] is not divisible by 2, Alice's score is 0, while Bob's score is 1.
The score difference is -1, which is the maximum possible.
Therefore, the answer is -1 * 2 = -2. Modulo 109 + 7, this equals 1000000005.
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 106
*/

/*
For a particular value of k, we can traverse the entire array and find the maximum subarray sun using kandane algo,
this will happen in O(n), which is not an issue,
but what values can be k? we cannot traverse all values of k since k can be almost 10^6, which will give tle,
so we will find the prime factors of the elements present in the array using sieve method, and for each prime number we can
find the maximum subarray sum,
one moment why prime numbers only?
since in the question its mentioned we need to find the smallest k that divides a number right? which indirectly
points to prime number
*/

public class Divisble_Game{
     int mod=1000000007;
    public int divisibleGame(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int i=0; i<n; i++) max=Math.max(max,nums[i]);
        int primes[]=new int[max+1];
        //O(nlog(log n))
        for(int i=2; i<=(int)Math.sqrt(max); i++){
            if(primes[i]==1) continue;
            for(int j=i*i; j<=max; j=j+i){
                primes[j]=1;
            }
        }
        //list.size()~80000~10^4
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=2; i<=max; i++) {
            if(primes[i]==0) list.add(i);
        }
        if(list.isEmpty()) {
            list.add(2);
        }
        long sum=Long.MIN_VALUE;
        long fixed=0;
        //10^4*10^3~10^7
        for(int i=0; i<list.size(); i++){
            long temp=work(list.get(i),nums);
            if(temp>sum){
                sum=temp;
                fixed=list.get(i);
            }
            
        }
        return (int)(sum%mod*fixed%mod+mod)%mod;
    }
    long work(int k, int[] nums){
        int n=nums.length;
        long sum=0;
        long max=Long.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(nums[i]%k==0) sum+=nums[i];
            else sum-=nums[i];
            max=Math.max(max, sum);
            if(sum<0) {
                sum=0;
            }
            
        }
        return max;
    }

}