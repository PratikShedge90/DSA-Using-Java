import java.util.*;
import java.io.*;

public class LargestNum
{
   public static void main(String[] args) {
   	  
     int a[] = {33,55,11,22,6,5,8};
     if(a.length == 1){
     	 System.out.println(a[0]);
     }

     int max = a[0];
     for(int i=1; i<a.length; i++)
     {
         if(max <= a[i])
         {
             max = a[i];
         }
     }
     System.out.println(max);
   }

}
