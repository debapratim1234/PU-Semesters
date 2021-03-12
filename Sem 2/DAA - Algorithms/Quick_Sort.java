import java.io.*;
public class Quick_Sort
{
  void QuickSort(int a[],int p,int q)  
   {  
    int j;
    if(p<q)   // if there are more than one element
    {
        //divide into two sub-problems
        j=Partition(a,p,q);   // j is the position of the partitioning element
        //Solve the sub-problems
        QuickSort(a,p,j-1);
        QuickSort(a,j+1,q);
    }
   }
  int Partition(int a[],int m,int p)
   {
    int v,i,j,temp;
    v=a[m];
    i=m;
    j=p+1;
    do
    {
        do
            i++;
        while(a[i]<v && i<=p);
        do
            j--;
        while(v<a[j]);
        
        if(i<j)
        {
            //Exchange a[i] with a[j]
            temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }
    }
    while(i<j);
    
    a[m]=a[j];
    a[j]=v;
    return(j);
   }
  public static void main(String args[])throws IOException
    {
      BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
      int n,i;
      int a[]=new int[50];
      Quick_Sort obj=new Quick_Sort();
      System.out.println("Enter the number of elements : ");
      n=Integer.parseInt(in.readLine());
      System.out.println("Enter array elements: ");
    
      for(i=0;i<n;i++)
        a[i]=Integer.parseInt(in.readLine());
        
      obj.QuickSort(a,0,n-1);
      System.out.println("Array after sorting: ");
    
      for(i=0;i<n;i++)
        System.out.println(a[i]);
    
    }
}
