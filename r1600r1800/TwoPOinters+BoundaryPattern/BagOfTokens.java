package r1600r1800.TwoPOinters+BoundaryPattern;

public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n=tokens.length;
        Arrays.sort(tokens);
        int i=0;
        int j=n-1;
        int score=0;
        int max=0;
        while(i<=j){
            if(power>=tokens[i]){
                power-=tokens[i++];
                max=Math.max(max,++score);
            }
            else if(score>0){
                power+=tokens[j--];
                score--;
            }
            else break;
        }
        return max;
        
        
    }
}
