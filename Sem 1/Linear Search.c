#include<stdio.h>

void main()
{
 int arr[50],n,i,z,flag=0;char ch;
 printf("Enter the size of the array: ");
 scanf("%d",&n);
 printf("\nEnter the elements in the list:\n");
 
 for(i=0;i<n;i++)
 {
 	scanf("%d",&arr[i]);
 }
 
 do
 {
  printf("\nEnter the element to be searched :");
  scanf("%d",&z);
  for(i=0;i<n;i++)
  {
  	if(arr[i]==z)
  	{
  	printf(" SEARCH SUCCESSFUL ! The number is found at position %d\n",i+1);
  	flag=1;
    }
  }
 if(flag==0)
 {
  printf(" SEARCH UNSUCCESSFUL ! The number is not found.");
  }
 printf("\nDo you want to search again ? (y/n)\n");
 ch=getche(); 
 flag=0;
 }
 while(ch=='y'||ch=='Y');
}
