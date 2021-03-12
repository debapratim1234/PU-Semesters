#include<stdio.h>
#include<conio.h>

int adj_matrix[10][10],picked[10],n,cost=0;
int minimum (int);

void input()   // method for taking input the no.of nodes and the adjacency matrix
{
int i,j;
printf("Enter the no. of Cities: ");
scanf("%d",&n);
printf("\nEnter the cost adjacency Matrix\n");
for(i=0;i<n;i++)
{
printf("\nEnter the elements of in row  : %d\n",i+1);
for( j=0;j<n;j++)
scanf("%d",&adj_matrix[i][j]);
picked[i]=0; //Initialize
}
printf("\n\nThe cost adjacency matrix is:\n\n");
for( i=0;i<n;i++)
{
printf("\n\n");
for(j=0;j < n;j++)
printf("\t%d",adj_matrix[i][j]);
}
}
void mincost(int city)  //method to calculate the path and the minimum cost
{
int i,ncity;
picked[city]=1;
printf("%d -->",city+1);
ncity=minimum(city);
if(ncity==999)
{
ncity=0;  
printf("%d",ncity+1);
cost+=adj_matrix[city][ncity];
return;
}
mincost(ncity);
}
int minimum(int c)   //method for selecting the minimum cost path
{
int i,nc=999;
int min=999,kmin;
for(i=0;i<n;i++)
{
if((adj_matrix[c][i]!=0)&&(picked[i]==0))
if(adj_matrix[c][i] < min)
{
min=adj_matrix[i][0]+adj_matrix[c][i];
kmin=adj_matrix[c][i];
nc=i;
}
}
if(min!=999)
cost+=kmin;
return nc;
}
void display()   // method for displaying the travelling salesman minimum cost
{
printf("\n\nMinimum cost:");
printf("%d",cost);
}
int main()
{
input();
printf("\n\nThe minimum cost path is:\n\n");
mincost(0);
display();
getch();
return 0;
}
