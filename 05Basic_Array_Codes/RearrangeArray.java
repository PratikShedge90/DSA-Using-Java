import java.util.*;
import java.io.*;

public class RearrangeArray
{
	public static void main(String[] args) {
		
        // Re-arranging the Array in Increasing Order -->

		int arr[] = {84,43,23,11,53,76};

		for(int i=0; i<arr.length; i++)           
		{
			for(int j=arr.length-1; j>=i; j--)
			{
				if(arr[i] < arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;        
				}
			}
		}
	// Time Complexity: 1) Best Case : O(n2)	
	}
}