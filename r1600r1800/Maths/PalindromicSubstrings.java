package r1600r1800.Maths;

public class PalindromicSubstrings {
     public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        for(int i=0; i<n; i++){
            int left=i;
            int right=i;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                    count++;
                    left--;
                    right++;
                
            }
            left=i;
            right=i+1;
             while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                    count++;
                    left--;
                    right++;
                
            }
        }
        return count;
    }
}
