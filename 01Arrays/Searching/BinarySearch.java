public class BinarySearch 
{
	public static int binarySearch(int a[], int key)
	{
		if(a ==null) { 
			return -1;
		}
		
		int lb = 0;
		int ub = a.length-1;
		int mid = -1;
		while(lb<=ub)
		{
		     mid = (lb + ub)/2;
		    if(a[mid] == key)
		    {
		    	return mid;
		    }
		    else if(key < a[mid])
		    {
		    	ub = mid-1;
		    }
		    else
		    {
		    	lb = mid+1;
		    }
		}
		return -(lb+1);
	}
	
	public static void main(String[] args) {

		int a[] = {11,22,33,44,55,66,77,88};
		int index = binarySearch(a,68);
		System.out.println(index);
		
		if(index<0)
		{
			System.out.println("Not Found");
		}
		else
		{
			System.out.println("Found");
     	}
	}
}
