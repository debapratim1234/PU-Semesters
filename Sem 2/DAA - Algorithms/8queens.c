#include<stdio.h>
#include<math.h>
 
int x[20],count;
 
int main()
{
 int n,i,j;
 void queen(int row,int n);
 
 printf(" - N Queens Problem Using Backtracking -");
 printf("\n\nEnter number of Queens:");
 scanf("%d",&n);
 NQueens(1,n);
 return 0;
}
 
//function for printing the solution
void print(int n)
{
 int i,j;
 printf("\n\nSolution %d:\n\n",++count);
 
 for(i=1;i<=n;i++)
  printf("\t%d",i);
 
 for(i=1;i<=n;i++)
 {
  printf("\n\n%d",i);
  for(j=1;j<=n;j++) //for nxn board
  {
   if(x[i]==j)
    printf("\tQ"); //queen at i,j position
   else
    printf("\t-"); //empty slot
  }
 }
}
 
/*funtion to check conflicts : can a new queen be placed ?
If no conflict for desired postion returns 1 otherwise returns 0*/
int Place(int k,int i)
{
 int j;
 for(j=1;j<=k-1;j++)
 {
  //checking column and digonal conflicts
  if((x[j]==i) || abs(x[j]-i)==abs(j-k))
   return 0;
  }
 return 1; //no conflicts
}
 
//function to check for proper positioning of queens i.e. providing solutions
void NQueens(int k,int n)
{
 int i; //i represents column
 for(i=1;i<=n;i++)
 {
  if(Place(k,i))
  {
    x[k]=i; //no conflicts so place queen
    if(k==n) //dead end
    print(n); //printing the board configuration
    else //try queen with next position
    NQueens(k+1,n);
  }
 }
}
