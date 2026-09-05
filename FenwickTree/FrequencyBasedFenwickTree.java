package FenwickTree;
/*
This is used to count elements less than a given value.

Count the number of elements less than or equal to x
Count the number of elements between x and y

Let’s try to build tree with assumption that input array have only positive and unique elements.
Find out the max value in the input array.
We will use MAX_VALUE+1 as size of Fenwick tree.
Here index in tree will represent the all possible elements.
Each element’s weight be considered as 1 therefore partial sum will be nothing but counting the frequency.
*/
import java.io.IOException;

public class FrequencyBasedFenwickTree {
    public int arr[];

    public FrequencyBasedFenwickTree(int n){
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
     public static void main(String[] args){
        int max=0;
        int data[]={6,9,1,8,4};
        for(int i=0; i<5; i++) max=Math.max(max,data[i]);
        FrequencyBasedFenwickTree tree=new FrequencyBasedFenwickTree(max);
        for(int i=0; i<5; i++) tree.insert(1,data[i]);
        System.out.println("hello"+" "+max+" "+tree.arr.length);
        tree.display();
     }
    
}
