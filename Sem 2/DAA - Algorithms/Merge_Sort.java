import java.io.*;
public class Merge_Sort
{
    void MergeSort(int a[],int low,int high) 
   {
    int mid;
    if(low<high)  //If there are more than one element
    {
        //Divide P into sub-problems
        //Find where to split the set
        mid=(low+high)/2;
        //Solve the sub-problems
        MergeSort(a,low,mid);        
        MergeSort(a,mid+1,high);
        //Combine these solutions
        Merge(a,low,mid,mid+1,high);    
    }
   }
   
    void Merge(int a[],int i1,int j1,int i2,int j2)
   {
    int temp[]=new int[50];    //array used for merging
    int i,j,k;
    i=i1;    //beginning of the first list
    j=i2;    //beginning of the second list
    k=0;
    
    while(i<=j1 && j<=j2)    //while elements in both lists
    {
        if(a[i]<a[j])
            temp[k++]=a[i++];
        else
            temp[k++]=a[j++];
    }
    
    while(i<=j1)    //copy remaining elements of the first list
      temp[k++]=a[i++];
        
    while(j<=j2)    //copy remaining elements of the second list
        temp[k++]=a[j++];
        
    //Transfer elements from temp[] back to a[]
    for(i=i1,j=0;i<=j2;i++,j++)
        a[i]=temp[j];
   }
   
   public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n,i;
        int a[]=new int[10];
        System.out.println("Enter no of elements:");
        n=Integer.parseInt(in.readLine());
        System.out.println("Enter array elements:\n");
        Merge_Sort ob=new Merge_Sort();
        for(i=0;i<n;i++)
         a[i]=Integer.parseInt(in.readLine());
        ob.MergeSort(a,0,n-1);
        System.out.println("Sorted array is :\n");
        for(i=0;i<n;i++)
        System.out.println(a[i]);
    }
}