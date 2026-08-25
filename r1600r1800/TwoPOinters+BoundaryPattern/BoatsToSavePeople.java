package r1600r1800.TwoPOinters+BoundaryPattern;
/*
Two pointers boundary pattern
In array [2,3,4,5] limit=5
since 2 cannot be paired with 4 and 5, we have to find the largest number x so that 2+x<=limit,
we are saving 2 for the largest number, if 2 cannot be paired with a  number here 4 and 5, it cant be paired by any and we requires 
separate boats for them. 
*/
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        int n=people.length;
        Arrays.sort(people);
        int count=0;
        int left=0;
        int right=n-1;
        while(left<=right && right<n){
            while(left!=right && (people[right]+people[left])>limit){
                right--;
                count++;
            }
            count++;
            left++;
            right--;
            
        }
        return count;
    }
}
