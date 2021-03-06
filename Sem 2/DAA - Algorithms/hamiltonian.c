#include<stdio.h> 
//We take the maximum number of vertices in the graph to be 5. 
#define V 5 
//We create a boolean data type with true and false values 
typedef enum
{
 false=0,true=1
} 
bool ;
void printSolution(int path[]); //Print function declaration
bool isSafe(int v,bool graph[V][V],int path[],int pos) 
/* A function to check if the vertex v can be added at 
index 'pos' in the Hamiltonian Cycle constructed so far (stored 
in 'path[]') */
{ 
int i;
/* Check if this vertex is an adjacent vertex of the previously 
added vertex. */
if(graph[path[pos-1]][v]==0) 
return false; 
/* Check if the vertex has already been included. 
 This step can be optimized by creating an array of size V */
for(i=0;i<pos;i++) 
if (path[i] == v) 
return false; 
return true; 
} 
/* A recursive function to solve hamiltonian cycle problem */
bool hamCycleUtil(bool graph[V][V],int path[],int pos) 
{ 
int v;
/* base case: If all vertices are included in Hamiltonian Cycle */
if (pos==V) 
{ 
// And if there is an edge from the last included vertex to the 
// first vertex 
if(graph[path[pos-1]][path[0]]==1) 
return true; 
else
return false; 
} 
// Try different vertices as a next candidate in Hamiltonian Cycle. 
// We don't try for 0 as we included 0 as starting point in in hamCycle() 
for (v=1;v<V;v++) 
{ 
/* Check if this vertex can be added to Hamiltonian Cycle */
if (isSafe(v,graph,path,pos)) 
{ 
path[pos] = v; 
/* recur to construct rest of the path */
if (hamCycleUtil(graph,path,pos+1)==true) 
return true; 
/* If adding vertex v doesn't lead to a solution, 
then remove it */
 path[pos]=-1; 
        } 
    } 
/* If no vertex can be added to Hamiltonian Cycle constructed so far, 
then return false */
return false; 
} 
/* This function solves the Hamiltonian Cycle problem using Backtracking.*/
bool hamCycle(bool graph[V][V]) 
{ 
int *path[V],i;
for (i=0;i<V;i++) 
path[i] = -1; 
/* Let us put vertex 0 as the first vertex in the path. If there is 
 a Hamiltonian Cycle, then the path can be started from any point 
of the cycle as the graph is undirected */
path[0]=0; 
if(hamCycleUtil(graph,path,1)==false) 
{ 
printf("\nSolution does not exist"); 
return false; 
} 
printSolution(path); 
return true; 
} 
/* A utility function to print solution */
void printSolution(int path[]) 
{ 
int i;
printf ("Solution Exists:"" Following is one Hamiltonian Cycle \n"); 
for (i=0;i<V;i++) 
printf(" %d ",path[i]); 
// Let us print the first vertex again to show the complete cycle 
printf(" %d ",path[0]); 
printf("\n"); 
} 
//main method 
int main() 
{ 
/* Let us create the following graph 
    (0)--(1)--(2) 
    |    / \   | 
    |   /   \  | 
    |  /     \ | 
    (3)-------(4)    */
 bool graph1[V][V]={{0, 1, 0, 1, 0}, 
                    {1, 0, 1, 1, 1}, 
                    {0, 1, 0, 0, 1}, 
                    {1, 1, 0, 0, 1}, 
                    {0, 1, 1, 1, 0}}; 
  
// Print the solution 
printf("For Graph 1 :\n");
hamCycle(graph1); 
/* Let us create the following graph 
      (0)--(1)--(2) 
       |   / \   | 
       |  /   \  | 
       | /     \ | 
      (3)       (4)    */
bool graph2[V][V] = {{0, 1, 0, 1, 0}, 
                    {1, 0, 1, 1, 1}, 
                    {0, 1, 0, 0, 1}, 
                    {1, 1, 0, 0, 0}, 
                    {0, 1, 1, 0, 0} }; 
  
// Print the solution 
printf("\n\nFor Graph 2 :\n");
hamCycle(graph2); 
return 0; 
} 

