
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
/*
We can do DP same pattern like Minimum_XOR_Path_To_Grid, but the problem is since the constraints are high we cannot use that pattern,
it gives TLE-
class Solution {
    public int minimumOR(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            ans=Math.min(ans, work(0,i,0,grid));
        }
        return ans;
    }
    int work(int i, int j, int val, int[][] grid){
        if(i==grid.length-1) return val | grid[i][j];
        int ans=Integer.MAX_VALUE;
        for(int k=0; k<grid[0].length; k++){
            ans=Math.min(ans,work(i+1,k,val|grid[i][j],grid));
        }
        return ans;
    }
}

The below solution is a beautiful way to solve this problem, where we use bit manipulation, we traverse bitwise, assuming through
constraints that the number of bits cannot exceed 25, we start traversing from high bit to lover bit that is from 25 to 0,
here for each bit say i that ranges from 25 to 0, we traverse entire row and entire matrix, why?
We traverse entire row, to check whether we have atleast one number which does not have 1 in that ith position, thus working greedily,
if yes then we go to the next row, if no, we now realize that this particular ith bit has to be checked in the ans because we could not
find any number that could help us escape, if due to good luck, we end uo traversing the entire matrix and managed to escape
the bit, then the ith bit will be 0 in the ans, and the test will be now forbidden=test, since in the later future also
we have to make sure that this ith bit is not checked by some other element what does that mean?
suppose,
2 3 5
8 9 7, now here when i=4, we see the first row we can escape even for second row we can escape,
escape in the sense there is atleast one element in that row whose ith bit is not checked,
so definitely now ith bit that is the fourth bit from the last has to be 0 in the ans ,
somewhat like this 0000, now when i=3, we will be able to escape the first row, and when traversing the second row, we
see that 0100&10001=0, the 3rd bit is not checked in 9, but should we take it?
No, since the 4th bit from last is checked in 9, that is 1001, so in my ans the 4th bit should be 0, not 1, 
because of which in order to respect previous forbidden bits, we do forbidden=text, so that in the future checks, the previous 
forbidden bits will also be considered.
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
