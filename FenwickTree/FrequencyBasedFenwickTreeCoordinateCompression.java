package FenwickTree;
import java.util.*;
public class FrequencyBasedFenwickTreeCoordinateCompression {
    public int arr[];

    public FrequencyBasedFenwickTreeCoordinateCompression(int n){
        arr=new int[n+1];
    }

    public int query(int index){
       
        index++;
        int sum=0;
        while(index>=1){
            sum+=arr[index];
            index=parent(index);
        }
        
        return sum;
    }
    public int queryTwo(int a, int b){
        return query(b)-query(a-1);
    }
    public void insert(int val, int index){
        index++;
        while(index<arr.length){
            arr[index]+=val;
            index=next(index);
            
        }
    }
    public void display(){
        for(int i=0; i<arr.length; i++) System.out.print(arr[i]+" ");
        System.out.println();
    }
    int next(int index){
        int val=~index;
        val+=1;
        val=val&index;
        val+=index;
        return val;
    }
    int parent(int index){
         int val=~index;
        val+=1;
        val=val&index;
        val=index-val;
        return val;
    }
     public static void main(String[] args){
        int data[]={1,1,1,8,4};
        Arrays.sort(data);
        HashSet<Integer> set=new HashSet<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0; i<5; i++) set.add(data[i]);
        int j=0;
        for(int num:set){
            map.put(num,j++);
        }
        FrequencyBasedFenwickTree tree=new FrequencyBasedFenwickTree(set.size());
        for(int i=0; i<5; i++) tree.insert(1, map.get(data[i]));
        tree.display();
        System.out.println(tree.query(2));
     }
}
