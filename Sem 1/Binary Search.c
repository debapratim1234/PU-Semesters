#include<stdio.h>

void main()
{
	int n,i,arr[50],j,min,temp,z,l,u,mid,flag=0;char ch;
	printf("Enter the size of the array: ");
	scanf("%d",&n);
	printf("\nEnter the elements in the array:\n");
	for(i=0;i<n;i++)
	{
		scanf("%d",&arr[i]);
	}
	
	//perform sorting of the list
	
	for(i=0;i<n-1;i++)
	{
		min=i;
		for(j=i+1;j<n;j++)
		{
			if(arr[j]<arr[min])
			{
				min=j;
			}
		}
		temp=arr[i];
		arr[i]=arr[min];
		arr[min]=temp;
	}
	
	//printing the sorted list
	
	printf("Sorted list :\n");
	for(i=0;i<n;i++)
	{
		printf("%d\n",arr[i]);
	}
	
	do
	{
	printf("\nEnter the element to be searched : ");
	scanf("%d",&z);
	l=0;
	u=n-1;
	while(l<=u)
	{
		mid=(l+u)/2;
		if(z==arr[mid]) 
		{
			flag=1;
			printf("SEARCH SUCCESSFUL ! The element is present at position %d",mid+1);
			break;
		}
		if(arr[mid]<z)
		l=mid+1;
		if(arr[mid]>z)
		u=mid-1;
    }

	if(flag==0)
	printf("SEARCH UNSUCCESSFUL ! The element is not present in the list.");
	printf("\nDo you want to continue the search ? (y/n)");
	ch=getche();
    }
    while(ch=='y'||ch=='Y');
}
