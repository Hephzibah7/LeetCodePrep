package Contest2ndQuestions;

public class MinimumOperationsToMakeARotatedPalindrome {
    public int minOperations(String s) {
        int n=s.length();
        int ans=1000000000;
        for(int i=0; i<n; i++){
            StringBuilder sb1=new StringBuilder(s.substring(i));
            StringBuilder sb2=new StringBuilder(s.substring(0,i));
            StringBuilder sb=sb1.append(sb2);
            int left=0;
            int right=n-1;
            int diff=i;
            while(left<=right){
                int a=sb.charAt(left);
                int b=sb.charAt(right);
                int c='z';
                int temp=0;               
                if(a<b) temp=Math.min(b-a,c-b+a+1-97);
                else temp=Math.min(a-b,c-a+b+1-97);
                diff+=temp;
                left++;
                right--;
            }
            ans=Math.min(ans,diff);
        }
        return ans;
    }
}
