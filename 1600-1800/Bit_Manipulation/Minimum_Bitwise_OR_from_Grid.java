
/*
3858. Minimum Bitwise OR From Grid

You are given a 2D integer array grid of size m x n.

You must select exactly one integer from each row of the grid.

Return an integer denoting the minimum possible bitwise OR of the selected integers from each row.

 

Example 1:

Input: grid = [[1,5],[2,4]]

Output: 3

Explanation:

Choose 1 from the first row and 2 from the second row.
The bitwise OR of 1 | 2 = 3​​​​​​​, which is the minimum possible.
Example 2:

Input: grid = [[3,5],[6,4]]

Output: 5

Explanation:

Choose 5 from the first row and 4 from the second row.
The bitwise OR of 5 | 4 = 5​​​​​​​, which is the minimum possible.
Example 3:

Input: grid = [[7,9,8]]

Output: 7

Explanation:

Choosing 7 gives the minimum bitwise OR.
 

Constraints:

1 <= m == grid.length <= 105
1 <= n == grid[i].length <= 105
m * n <= 105
1 <= grid[i][j] <= 105

*/
public class Minimum_Bitwise_OR_from_Grid {
    public int minimumOR(int[][] grid) {
        int ans=0;
        int forbidden=0;
        for(int i=25; i>=0; i--){
            int test=forbidden| (1<<i);

            boolean possible=true;
            for(int row=0; row<grid.length; row++){
                boolean found=false;
                for(int j=0; j<grid[0].length; j++){
                    if((grid[row][j]&test)==0){
                        found=true;
                        break;
                    }
                }
                if(found==false){
                    possible=false;
                    break;
                }
            
            }

            if(possible==false){
                ans=ans | (1<<i);
            }
            else{
                forbidden=test;
            }
        }
        return ans;
    }
}
