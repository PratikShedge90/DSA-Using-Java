import java.util.Arrays;

public class InsertionSort 
{

	public static void insertionSort(int[] a)
	{
		for(int i=1; i<a.length; i++)       // --> 11,22,33,15,17,25,27
		{
			int t = a[i];
			
			int j;
			for(j=i-1; j>=0; j--)
			{
				if(a[j] > t)
				{
					a[j+1] = a[j];
				}
				else
				{
					break;
				}
			}
			a[j+1]=t;
		}
		System.out.println(Arrays.toString(a));
		
	}

	public static void main(String[] args) {

		int[] a = {11,22,33,15,17,25,27};
		
		InsertionSort.insertionSort(a);
	
	}

}
