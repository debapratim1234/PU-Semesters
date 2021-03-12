import java.io.*;
class ShortestPaths
 { 
    private static final int NO_PARENT = -1; 
    private static void dijkstra(int cost[][],int src) 
    { 
        int n=cost[0].length; 
        // dist[i] will hold the shortest distance from src to i 
        int dist[]=new int[n]; 
        // added[i] will true if vertex i is 
        // included / in shortest path tree 
        // or shortest distance from src to  
        // i is finalized 
        boolean S[]=new boolean[n]; 
        // Initialize all distances as  
        // INFINITE and S[] as false 
        for (int i=0;i<n;i++) 
        { 
            dist[i]=Integer.MAX_VALUE; 
            S[i]=false; 
        } 
        // Distance of source vertex from  itself is always 0 
        dist[src]=0; 
        // Parent array to store shortest path tree 
        int parents[] = new int[n]; 
        // The starting vertex does not  have a parent 
        parents[src] = NO_PARENT; 
        // Find shortest path for all  vertices 
        for (int j=1;j<n;j++) 
        { 
            // Pick the minimum distance vertex from the set of vertices not yet processed.
            // nearestVertex is always equal to startNode in first iteration. 
            int nearestVertex = -1; 
            int shortestDistance = Integer.MAX_VALUE; 
            for (int i=0;i<n;i++) 
            { 
                if (!S[i] && dist[i] < shortestDistance)  
                { 
                    nearestVertex=i; 
                    shortestDistance=dist[i]; 
                } 
            } 
            // Mark the picked vertex as visited.
            S[nearestVertex]=true; 
            // Update dist value of the adjacent vertices of the picked vertex. 
            for (int i=0;i<n;i++)  
            { 
                int edgeDistance=cost[nearestVertex][i]; 
                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < dist[i]))  
                { 
                    parents[i]=nearestVertex; 
                    dist[i]=shortestDistance+edgeDistance; 
                } 
            } 
        } 
         printSolution(src,dist,parents); 
    } 
    // A utility function to print the constructed distances array and shortest paths 
    private static void printSolution(int src,int dist[],int[] parents) 
    { 
        int n = dist.length; 
        System.out.print("Vertex\t\tDistance\t\tPath"); 
          
        for (int i=0;i<n;i++)  
        { 
            if (i!= src)  
            { 
                System.out.print("\n" + src + " -> "); 
                System.out.print(i + " \t\t "); 
                System.out.print(dist[i] + "\t\t"); 
                printPath(i, parents); 
            } 
        } 
    } 
     // Function to print shortest path from source to currentVertex using parents array 
    private static void printPath(int currentVertex,int[] parents) 
    { 
        // Base case : Source node has been processed 
        if (currentVertex == NO_PARENT) 
        { 
            return; 
        } 
        printPath(parents[currentVertex], parents); 
        System.out.print(currentVertex + " -> "); 
    } 
     // Here we have assigned the adjacency matrix 
    public static void main(String[] args)throws IOException
    { 
        int cost[][] =            { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                                    { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                                    { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                                    { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                                    { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                                    { 0, 0, 4, 0, 10, 0, 2, 0, 0 }, 
                                    { 0, 0, 0, 14, 0, 2, 0, 1, 6 }, 
                                    { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                                    { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
        BufferedReader in=new BufferedReader (new InputStreamReader(System.in));
        System.out.println("Enter the source vertex : ");  //Take source vertex as user input
        int c=Integer.parseInt(in.readLine());
        if(c>=0 && c<=cost[0].length-1)
        dijkstra(cost,c); 
        else
        {
            System.out.println("Source vertex not found !!");
            System.exit(0);
        }
    } 
} 