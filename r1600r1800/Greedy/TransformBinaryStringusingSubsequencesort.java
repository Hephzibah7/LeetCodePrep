/*
https://leetcode.com/problems/transform-binary-string-using-subsequence-sort/
 */

/*
This question is pure pure greedy that one can come up with crucial and hard to catch observations, lets recall-
observation1 -
since we have right to sort the s string, it means the zeros can come left and ones can go right,
lets notice one of the bit, say zeros alright?
so basicall if s=101 t=001, I can sort a s and so s equals t,
but what if s=101, t=010, then in no way i can bring 0 from 1th index to 2nd index right?
so 0 can be replaced and shifted to 0...ith position if 0 is in ith position in s string

observation 2-
in order for s to be equal to t, the primary need is the number of zeros should be equal to number of 1s
we will work greedily and add as required number of 0's first and then when no more zeros are required but still ? is left, we
can replace them with '1s'. we wil add 0's first and then 1's, why?
thats intuitive right?
more 0's on the left in t, in that way if we sort s, there is more probability that string t and s can match
*/

package r1600-r1800.Greedy;

public class TransformBinaryStringusingSubsequencesort {
    public boolean[] transformStr(String s, String[] strs) {
        int n=s.length();
        int len=strs.length;
        boolean ans[]=new boolean[len];
        int counttargetz=0;
        ArrayList<Integer> list1=new ArrayList<>();
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='0') list1.add(i);
        }
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='0') counttargetz++;
        }
        for(int i=0; i<len; i++){
            int actualz=0;
            int replace=0;
            StringBuilder str=new StringBuilder(strs[i]);
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j)=='?') replace++;
                if(str.charAt(j)=='0') actualz++;
            }
            if(actualz>counttargetz || actualz+replace<counttargetz) {
                ans[i]=false;
                continue;
            }
            int need=counttargetz-actualz;
            
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j)=='?'){
                    if(need>0){
                        str.setCharAt(j,'0');
                        need--;
                    }
                    else str.setCharAt(j,'1');
                } 
            }
            
            ArrayList<Integer> list2=new ArrayList<>();
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j)=='0') list2.add(j);
            }

            boolean val=true;
            
            for(int j=0; j<list1.size(); j++){
                if(list2.get(j)>list1.get(j)){
                    val=false;
                    break;
                }
            }
            ans[i]=val;

        }
        return ans;
    }
}
