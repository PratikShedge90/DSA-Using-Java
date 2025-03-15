
import java.util.Arrays;
public class SelectionSort {
	
	public static void selectionSort(int a[])
	{
		// 33, 55, 22, 11, 44	
		int n = a.length;
		
		for(int i=0; i<n; i++)
		{
			for(int j=i+1; j<n; j++)
			{
				if(a[i] > a[j])
				{
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
 				}
			}
		}
    	System.out.println(Arrays.toString(a));		
	}

	public static void main(String[] args) {
		
		int a[] = {33,55,22,11,44};	
    	selectionSort(a);
	}
}
