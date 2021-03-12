#include <stdio.h>
#include <limits.h>
#include<stdbool.h>
// Number of vertices in the graph 
#define V 5 

// A utility function to find the vertex with  
// minimum key value, from the set of vertices  
// not yet included in MST 
int minKey(int key[], bool mstSet[]) 
{ 
// Initialize min value 
int min = INT_MAX, min_index; 
int v;
for( v = 0; v < V; v++) 
    if (mstSet[v] == false && key[v] < min) 
        min = key[v], min_index = v; 

return min_index; 
} 


int printMST(int parent[], int n, int graph[V][V]) 
{ 
printf("Edge \tWeight\n");
 int i;
for ( i = 1; i < V; i++) 
    printf("%d - %d \t%d \n", parent[i], i, graph[i][parent[i]]); 
} 

void primMST(int graph[V][V]) 
{ 
    // Array to store constructed MST 
    int parent[V];  

    int key[V];  
    bool mstSet[V];  

    // Initialize all keys as INFINITE 
    int i;
    for ( i = 0; i < V; i++) 
        key[i] = INT_MAX, mstSet[i] = false; 

    key[0] = 0;      
    parent[0] = -1; // First node is always root of MST  

    // The MST will have V vertices 
    int count;
    for (count = 0; count < V-1; count++) 
    { 
        int u = minKey(key, mstSet); 

        // Add the picked vertex to the MST Set 
        mstSet[u] = true; 
         int v;
        for ( v = 0; v < V; v++) 


        if (graph[u][v] && mstSet[v] == false && graph[u][v] < key[v]) 
            parent[v] = u, key[v] = graph[u][v]; 
    } 

    // print the constructed MST 
    printMST(parent, V, graph); 
} 


// driver program to test above function 
int main() 
{ 
/* Let us create the following graph 
        2 3 
    (0)--(1)--(2) 
    | / \ | 
    6| 8/ \5 |7 
    | /     \ | 
    (3)-------(4) 
            9         */
int graph[V][V] = {{0, 2, 0, 6, 0}, 
                    {2, 0, 3, 8, 5}, 
                    {0, 3, 0, 0, 7}, 
                    {6, 8, 0, 0, 9}, 
                    {0, 5, 7, 9, 0}}; 

    // Print the solution 
    primMST(graph); 

    return 0; 
}






















