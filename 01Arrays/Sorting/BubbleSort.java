import java.util.Arrays;

public class BubbleSort {
	
	public static int[] bubbleSort(int[] a)
	{
		int n = a.length;
		for(int i=n-1; i>=0; i--)
		{
			for(int j=0; j<i; j++)
			{
				if(a[j] > a[j+1])
				{
					int temp= a[j];
					a[j]    = a[j+1];
					a[j+1]  = temp;
				}
			}
		}
		return a;
	}

	public static void main(String[] args) 
	{
		int[] a = {94,125,6,39,10};	
		int[] result = bubbleSort(a);	
		System.out.println(Arrays.toString(result));
		
		// Time Complexity : O(n2)
		// Space Complexity: O(1)
		// Eventhough data is Sorted or Unsorted It Will take O(n2) 	
	}

}
