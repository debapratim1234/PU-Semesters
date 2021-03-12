import java.io.*;
import java.lang.Math;
class Binary_Srch
{
    static int a[],i,l,x,n;
    //Implementation of Recursive Binary Search Algorithm
    public int Bin_Srch(int a[],int i,int l,int x)     
    {
        int mid;
        if(l>=i)
        {
            //reduce into smaller sub-problems
            mid=(int)((i+l)/2);                    
            if(x==a[mid])
            return mid;
            else if(x<a[mid])
            return Bin_Srch(a,i,mid-1,x);
            else
            return Bin_Srch(a,mid+1,l,x);
        }
        else
        return -1;
    }
    public static void main(String args[])throws IOException
    {
     int min,temp,ch;
     BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
     //Enter the size of the array.
     System.out.println("Enter the size of the array :");
     n=Integer.parseInt(in.readLine());
     i=0;
     l=n-1;
     a=new int[n];
     //Enter the elements in the array.
     System.out.println("Enter the elements in the list : ");
     for(int t=0;t<n;t++)
     {
     a[t]=Integer.parseInt(in.readLine());
     }
     //Sort the array elements in non-decreasing order
     for(int t=0;t<n-1;t++)
     {
		min=t;
		for(int u=t+1;u<n;u++)
		{
			if(a[u]<a[t])
			{
				min=u;
			}
		}
		temp=a[t];
		a[t]=a[min];
		a[min]=temp;
      }
      // Display the sorted list.
     System.out.println("Sorted list :");
     for(int t=0;t<n;t++)
      {
           System.out.println(a[t]);
      }
      //Print the result
     do
     {
         int res;
         System.out.println("Enter the element to be searched :");
         x=Integer.parseInt(in.readLine());
         Binary_Srch bs=new Binary_Srch();
         res=bs.Bin_Srch(a,i,l,x);
         if(res==-1)
         {
           System.out.println("SEARCH UNSUCCESSFUL ! The element is not present in the list.");
         }
         else
         {
           System.out.println("SEARCH SUCCESSFUL ! The element is present at position "+(res+1));  
         }
         System.out.println("*** Press any number to continue *** Press 0 to exit ***");
	 ch=Integer.parseInt(in.readLine());
      }
      while(ch!=0);
    }
}
    
