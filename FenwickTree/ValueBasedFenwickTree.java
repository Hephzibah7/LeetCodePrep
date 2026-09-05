package FenwickTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValueBasedFenwickTree {
    public int arr[];

    public ValueBasedFenwickTree(int n){
        arr=new int[n+1];
    }

    public void update(int val, int index){
        index++;
        int temp=arr[index]-arr[index-1];
        int diff=val-temp;
        insert(diff,index);
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
   


}
