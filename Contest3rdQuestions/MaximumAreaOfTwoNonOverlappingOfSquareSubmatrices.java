/*
Learn how to find prefix sum of a submatrice of a matrix or grid using prefix sum 2D

*/



package Contest3rdQuestions;

public class MaximumAreaOfTwoNonOverlappingOfSquareSubmatrices {
     public int maxArea(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int maxk=Math.min(m,n);
        int prefix[][]=new int[m+1][n+1];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) prefix[i+1][j+1]=mat[i][j]+prefix[i+1][j]+prefix[i][j+1]-prefix[i][j];
        }
        int[][] bounds=new int[maxk+1][5];
        for(int k=1; k<=maxk; k++){
            bounds[k][0]=m;
            bounds[k][1]=-1;
            bounds[k][2]=n;
            bounds[k][3]=-1;
            bounds[k][4]=0;
        }
        for(int k=1; k<=maxk; k++){
            for(int i=0; i<=m-k; i++){
                for(int j=0; j<=n-k; j++){
                     int totalOnes = prefix[i + k][j + k] - prefix[i][j + k] - prefix[i + k][j] + prefix[i][j];
                  
                    if (totalOnes == k * k) {
                        if (i < bounds[k][0]) bounds[k][0] = i;
                        if (i > bounds[k][1]) bounds[k][1] = i;
                        if (j < bounds[k][2]) bounds[k][2] = j;
                        if (j > bounds[k][3]) bounds[k][3] = j;
                        
                        bounds[k][4]++;
                    } 
                }
            }
        }

        for(int k=maxk; k>=1; k--){
            if(bounds[k][4]<2) continue;
            int x1=bounds[k][0];
            int x2=bounds[k][1];
            int y1=bounds[k][2];
            int y2=bounds[k][3];
            if(x2-x1>=k || y2-y1>=k) return k*k;
        }
        return 0;
    }
}
