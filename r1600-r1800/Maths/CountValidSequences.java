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
since both numerator and denominator can be very large, we need to mod it it in every step,
But as we know division does not work in modulo like multiplication does-
(a*b)mod m=((a mod m)*(b mod m)) mod m
so (a/b) mod m is not equal to ((a mod m)/(b mod m)) mod m
So instead of dividing them we multiply it with modulo inverse, that is
sum/dev=sum*(1/dev)=sum*(inverse(dev))
How do i find 1/dev mod m?
Finding the modulo inverse means finding an integer x such that when multiplied by dev is congruent to 1, mod m.
Can also be written as- 
dev*x congruent to 1 (mod m)
like if i want 5/3 mod 7 then,
3*x congruent to 1 (mod 7),
3*5=15%7=1, so x=5
3*5 congruent to 1(mod 7),
so 5/3 mod 7 can also be written as 5*5 mod 7=24 mod 7=4

So we need to check all possible values of x such that when multiplied with dev is congruent to 1 mod m,

so we do shortcut with the help of fermet theorem-
If m is prime,
a inverse=a^(mod-2) mod m, but manually finding power can be slow so we perform fast exponentiation,

Lets learn about fast exponentiation-
suppose i need to find value of 2^13
so b=2, e=13

r=1
binary form of 13=1101
1101&1=1 (e&1)
r=1*2=2 (b*r)

b=2*2=4, e=13/2=6
0110&1!=1
r=2

b=4*4=16, e=6/2=3
0011&1=1
r=2*16=32

b=16*16=256, e=3/2=1
0001&1=1
r=32*256=8192

b=8192*8192=65536 e=0 stop

Explanation-
3^13=13 times,
bianry exponentiation akss a different questions, can we write 13 as sum of powers of 2?
13=8+4+1
3^13=3^8*3^4*3^1, which means instead of 13 three's, we need only 3 numbers to be multiplied,
so how do we get this numbers?
(3^1)^2=3^2
(3^2)^2=3^4
(3^4)^2=3^8 hence b=b*b
how should we know whcih one to multiply
13=8+4+1=1101 (binary value of 13)
if in that bit 1 is there then multiply
*/

public class CountValidSequences {
     int mod = 1000000007;

    public int countValidSequences(int n, int k) {
        long total = findC(n - 1, k - 1);
        System.out.println(total);
        long odd = 0;
        if ((n - k) % 2 == 0)
            odd = findC(((n - k) / 2 + k - 1), k - 1);
        long res=((total-odd)+mod)%mod;
        return (int) (res);
    }

    long findC(int n, int r) {

        long sum = 1;
        long den=1;

        // Calculate the value of n choose r using the
        // binomial coefficient formula
        r=Math.min(r,n-r);

        for (int i = 1; i <= r; i++) {
            sum = sum * (n - r + i) % mod;
            den=den*i%mod;
        }

        return sum*power(den,mod-2)%mod;
    }
    long power(long b, long e) {
        long r = 1;
        for (; e > 0; e >>= 1, b = b * b % mod)
            if ((e & 1) == 1) r = r * b % mod;
        return r;
    }
}
