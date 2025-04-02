import java.util.*;
import java.io.*;

public class SmallestNum
{
   public static void main(String[] args) {
   	  
     int a[] = {33};

     if(a.length == 1){
     	 System.out.println(a[0]);
     }

     int min = a[0];

     for(int i=1; i<a.length; i++)
     {
     	if(min <= a[i])
     	{
     		continue;
     	}
     	else
     	{
     		min = a[i];
     	}
     }
     System.out.println(min);
   }

}
