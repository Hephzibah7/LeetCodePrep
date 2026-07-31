/*
We need to find the count of valid sequence that is what the question asks for-
What is a valid sequence-
-k positive integers
-sum of the elements=n
-product is even
-The brute force will give us TLE, that is to find all the sequences with sum n and product even.

Key observation-
-the product if even even if one element is even
-instead of counting even product sequences directly-
we find total sequences whose sum is n-sequences who sum is n and product is odd=gives us sequences whose sum is n and product is even
-the product of sequences is considered to be odd, if all the elements are odd.

To find the count of valid sequences we use Star and Bar method or also called Begger's method.

So first let's see what is star and bar method-
If you have n stars and you have k groups,

Case 1-when ai>=0
so in order to make k groups you need to make k-1 divisons, or you need to make k-1 divisions, right?
like this-
*|**|** so inorder to make 3 groups i needed 2 bars,
Now when ai>=0 here ai signifies ith group can contain 0 stars as well so this ||***** is basically possible,
so we have n+k-1 positions(stars and bars) to place k-1 bars,
so when ai>=0, then number of possible arrangements can be [n+k-1 C k-1].

Case 2- when ai>=1
so inorder to make k-1 bars we have total n-1 choices because each group should have atleast 1 star so,
*|*|*|*|*, so you can see if there are n stars, there are n bars positions available,
so when ai>=1, then number of possible arrangements can be [n-1 C k-1].

Okay so now according to question it is easy to find the total number of sequences where sum is n and groups or number of elements
is k, regardless of wheather the product is odd or even.
Now as i said we got total number of sequences, but we need total number of sequences with even product,
so we can get by first evaluating, number of sequences with odd product,
lets do that now-
odd numbers are in the form 2bi+1 where i is the ith element and main thing bi>=0
(2b1+1)+(2b2+1)...=n,
2(b1+b2...bk)+k=n,
b1...bk=(n-k)/2  

So now the sum is (n-k)/2, and number of groups or elements=k,
number of sequences with k groups and odd product is=[(n-k)/2+k-1 C k-1]
and also for the above equation to be true, n-k should always be even so that the the sum (b1..bk) is an integer.

Thus subtract the number of sequences with odd product from total number of sequences you get your answer.

Now the problem is java does not provide any in-built function to calculate the combination.
The formula of combination is as follows-
[n C r]=n!/(r!*(n-r)!) so if we manually calculate the factorial the number exceeds the limit and gives wrong answer,
since n can be as large as 10^6, so its factorial crosses the limit, so we optimize it,
that is for [n C r],
r=min(r,c-r), in this way ,
in n!/(r!*(n-r)!) , n-r becomes major part of n, and major part of n and n-r cancels out, like take this below example-
[6 C 2] = 6!/(2!*4!) = (6*5*4*3*2*1)/(2!*4!)=(6*5)/(2!),

*/

public class CountValidSequences {
    
}
