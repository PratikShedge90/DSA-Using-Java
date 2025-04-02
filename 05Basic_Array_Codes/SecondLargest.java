import java.util.Arrays;

// Brute Force Approach --> Time Complexity O(n logn) + O(n) = nlogn
class Solution {
    public int getSecondLargest(int[] arr) {

    Arrays.sort(arr);
    
    for(int i=arr.length-1; i>0; i--)
    {
        int max = arr[i];
        if(max !=arr[i-1])
        {
            return arr[i-1];
        }
    }
     return -1;
    }
}

// Optimal Solution -->  Time Complexity : O(n)

public static void main(String[] args)
{

    int a[] = {12,35,1,10,34,1};
    
    int largest = a[0];
    int secLargest = 0;

    for(int i=1; i<a.length; i++)
    {
        if(largest < a[i]){
            secLargest = largest;
            largest = a[i];
        }
        else if(a[i] < largest && a[i] > secLargest)
        {
            secLargest = a[i];
        }
    }
    System.out.println(secLargest);

}