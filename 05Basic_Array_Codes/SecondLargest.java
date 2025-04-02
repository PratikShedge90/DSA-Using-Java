import java.util.Arrays;

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