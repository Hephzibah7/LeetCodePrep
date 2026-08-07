//https://leetcode.com/problems/create-grid-with-exactly-k-paths-i/

/*
This solution uses a template-based
approach to build the grid.

For a given k,
we check if any of its predefined templates
can fit inside m * n boundaries.

If a template fits,
we copy its shape into the top-left corner of the grid,
which is initially filled with obstacles.

Then, we simply extend the path
from the bottom-right corner of the template
straight down, and then straight right,
until it reaches the grid's final cell.

If no template fits, it returns empty.
*/
import java.util.*;
public class CreateGridWithKPaths1 {
    public String[] createGrid(int m, int n, int k) {
        HashMap<Integer,String[][]> map=new HashMap<>();
        map.put(1,new String[][]{{"."}});
        map.put(2,new String[][]{{"..",".."}});
        map.put(3,new String[][]{{"...","..."},{"..","..",".."}});
        map.put(4,new String[][]{{"....","...."},{"..","..","..",".."},{"..#","...","#..."}});

        if(map.containsKey(k)){
            for(String str[]:map.get(k)){
                int r=str.length;
                int c=str[0].length();
                if(r>m || c>n) continue;
                System.out.println("hhel");
                char temp[][]=new char[m][n];
                for(int i=0; i<m; i++) Arrays.fill(temp[i],'#');
                for(int i=0; i<r; i++){
                    for(int j=0; j<c; j++){
                        temp[i][j]=str[i].charAt(j);
                    }
                }
                for(int i=r; i<m; i++) temp[i][c-1]='.';
                for(int j=c; j<n; j++) temp[m-1][j]='.';
                String res[]=new String[m];
                for(int i=0; i<m; i++){
                    res[i]=String.valueOf(temp[i]);
                }
                return res;
            }
        }
        return new String[0];
    }
}
