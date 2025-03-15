
public class LinearSearch {
	
	public static int linearSearch(int a[] , int key)
	{
		if(a == null){
			return -1;
		}
		
		for(int i=0; i<a.length; i++)
		{
			if(key == a[i]) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int a[] = {11,33,22,55,44};
		int key = 22;

		int index = linearSearch(a, key);
		if(index == -1) {
			System.out.println("No Element Found for Key :"  + key);
		}
		else {
			System.out.println("Element Found for key " + key + " at Index :"  + index);
		}
		
		
	}

}
