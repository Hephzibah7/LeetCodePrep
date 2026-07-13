

/*

3983. Subsequence After One Replacement
Attempted
Medium
premium lock icon
Companies
Hint
You are given two strings s and t consisting of lowercase English letters.

You may choose at most one index in s and replace the character at that index with any lowercase English letter.

Return true if it is possible to make s a subsequence of t; otherwise, return false.

 

Example 1:

Input: s = "cat", t = "chat"

Output: true

Explanation:

Replace s[1] from 'a' to 'h'. The resulting string is "cht".
"cht" is a subsequence of "chat" because we can match 'c', 'h', and 't' in order.
Example 2:

Input: s = "plane", t = "apple"

Output: false

Explanation:

The characters 'p', 'l', and 'e' can be matched in t, but the remaining characters cannot be matched while preserving the required order.
Even after replacing any one character in s, it is impossible to make s a subsequence of t.
 

Constraints:

1 <= s.length, t.length <= 105
s and t consist only of lowercase English letters.
 */



/* 


Wrong solutions-
The hashmap approach does not consider frequency, suppose even if the s string contains the character in string t, but it has
more frequency than the frequency of that character in t.
If you delete exactly one character from s, and the remaining characters can be matched in order inside t, then the deleted character can indeed be replaced by the corresponding character from t provided there is an available position between the matched prefix and suffix.
The issue is that your implementation doesn't verify that such a position exists.


ex- 
s=abxd
t=abd

now newstr=abd is the subsequence of abd but with what corresponding character will you replace x with
import java.util.*;
public class Subsequence_After_One_Replacement {
    class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n>m) return false;
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0; i<m; i++) map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        int count=0;
        int index=-1;

        
        for(int i=0; i<n; i++){
            if(!map.containsKey(s.charAt(i))){
                 count++;
                 index=i;
            }
        }
        if(count>1) return false;
        StringBuilder sb=new StringBuilder(s);
        if(count==1) sb.deleteCharAt(index);
        String newstr=String.valueOf(sb);
        int val=findLongestCommonSubsequence(0,0,newstr,t);
        if(val==newstr.length()) return true;
        return false;
    }
    int findLongestCommonSubsequence(int i, int j,String s, String t){
        if(i>=s.length() || j>=t.length()) return 0;
        if(s.charAt(i)==t.charAt(j)) return 1+findLongestCommonSubsequence(i+1,j+1,s,t);
        return Math.max(findLongestCommonSubsequence(i+1,j,s,t),findLongestCommonSubsequence(i,j+1,s,t));
    }
}
}

*/

/*
Two pointer solution-
In the previous solutions, LCS only tells you:
"The remaining characters can be matched.
It doesn't tell you where they were matched.
You need to know:
where the prefix matched,
where the suffix matched,
and whether there is at least one unused character of t between those matches for the replacement,
that means in simple terms for an index i to be replaced the prefix s[0...i-1] should be a subsequence of t and
s[i+1...n] should be a subsequence of t, so
say left[i]=earliest index in t where s[0...i-1] is already a subsequence of t
say right[i]=latest index in t where s[i+1...n-1] is already a subsequence of t,
ans right[i]-left[i] has atleast one character
Easy peesy



TC-O(n+m)
SC-(O(n))
 */
import java.util.*;
class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n=s.length();
        int m=t.length();
        int left[]=new int[n];
        int right[]=new int[n];
        Arrays.fill(left,-1);
        Arrays.fill(right,-1);
        int p=0;
        for(int i=0; i<n; i++){
            while(p<m && s.charAt(i)!=t.charAt(p)) p++;
            if(p==m) break;
            left[i]=p++;
        }
        if(left[n-1]!=-1) return true;
        p=m-1;
        for(int i=n-1; i>=0; i--){
            while(p>=0 && s.charAt(i)!=t.charAt(p)) p--;
            if(p<0) break;
            right[i]=p--;
        }
        for(int i=0; i<n; i++){
            if((i==0 || left[i-1]!=-1)&&(i==n-1 || right[i+1]!=-1)){
                int L=(i==0)?-1:left[i-1];
                int R=(i==n-1)?m:right[i+1];
                if(R-L>1) return true;
            }
        }
        return false;

    }
}
