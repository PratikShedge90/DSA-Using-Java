import java.util.*;
import java.io.*;


public class ReverseArray
{
	public static void main(String[] args) 
	{
         int[] arr = {11,22,33,44,55};
         for(int i=0, j= arr.length-1; i<j; i++,j--)
         {
         	 int temp = arr[i];
         	 arr[i] = arr[j];
         	 arr[j] = temp;
         }
         System.out.println(Arrays.toString(arr));

	}
}