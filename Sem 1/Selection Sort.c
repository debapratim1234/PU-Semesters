#include <stdio.h>

main()
{
  int arr[100], n, i, j, min, temp;
 
  printf("Enter number of elements\n");
  scanf("%d", &n);
 
  printf("Enter %d integers\n", n);
 
  for (i=0;i<n;i++)
    scanf("%d",&arr[i]);
 
  for (i=0;i<(n-1);i++)
  {
    min=i;
   
    for (j=i+1;j<n;j++)
    {
      if (arr[j]<arr[min])
        min=j;
    }
    temp=arr[i];
    arr[i]=arr[min];
    arr[min]=temp;
  }
  
 printf("Sorted list in ascending order:\n");
 
  for (i=0;i<n;i++)
    printf("%d\n", arr[i]);
 
}
