package r1600r1800.Graph;

public class Number_Of_Islands {
    int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]=='1' && vis[i][j] == 0) {
                    ans++;
                    dfs(i, j, grid, vis);
                }
            }
        }
        return ans;
    }

    void dfs(int i, int j, char[][] grid, int[][] vis) {
        vis[i][j] = 1;
        int[] dRow = { -1, 1, 0, 0 };
        int[] dCol = { 0, 0, -1, 1 };
        for(int t=0; t<4; t++){
            int row=i+dRow[t];
            int col=j+dCol[t];
            if(row<0 || row>=grid.length || col<0 || col>=grid[0].length) continue;
            if(grid[i][j]=='1' && vis[row][col]==0) dfs(row,col,grid,vis);

        }
    
}
