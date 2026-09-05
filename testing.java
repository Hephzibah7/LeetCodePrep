import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import FenwickTree.ValueBasedFenwickTree;

public class testing {
     public static void main(String[] args) throws IOException {
        ValueBasedFenwickTree tree=new ValueBasedFenwickTree(5);
        tree.insert(5, 0);
        tree.insert(1, 1);
        tree.insert(2, 2);
         tree.display();
        tree.update(4,1);
        tree.display();
        int ans=tree.queryTwo(1,2); 
        System.out.println(ans);
    }
}
