/*
    In this problem you need to find the longest absolute path to a file,
    so are using tab character to realize the depth of the file or directory,
    revision needed.
*/


package Google;
import java.util.*;
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        int n=input.length();
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0,0);
        String lines[]=input.split("\n");
        int max=0;
        for(String line:lines){
            int depth=0;
            while(depth<line.length() && line.charAt(depth)=='\t') depth++;
            String name=line.substring(depth);
            if(name.contains(".")) //its a file
            {
                max=Math.max(max, map.get(depth)+name.length());
            }
            //its a directory
            else{
                map.put(depth+1,map.get(depth)+1+name.length());
            }
        }
        return max;
    }
}
