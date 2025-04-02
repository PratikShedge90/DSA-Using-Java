import java.util.*;
import java.io.*;

public class SecondSmall
{
    public static void main(String[] args) 
    {
       
       int arr[] = {34,65,23,45,21,11,15};

        for(int i=arr.length-1; i>0; i--)
        {   
            for(int j=0; j<i; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j]   = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}