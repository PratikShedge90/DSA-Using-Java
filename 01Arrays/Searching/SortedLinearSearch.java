
public class SortedLinearSearch {
	
	public static int sortedlinearSearch(int[] a, int key)
	{
		if(a==null) {
			return -1;
		}
		for(int i=0; i<a.length; i++)
		{
			if(key==a[i])
			{
				return i;
			}
			if(key<a[i])
			{
				break;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		// Here is One Conditioon that the Array Should be Sorted 
		int[] a = {11,22,33,44,55};
		int key = 25;
		
		int index = sortedlinearSearch(a, key);
		if(index == -1) {
			System.out.println("No Element Found for Key :"  + key);
		}
		else {
			System.out.println("Element Found for key " + key + " at Index :"  + index);
		}
		
	}

}
