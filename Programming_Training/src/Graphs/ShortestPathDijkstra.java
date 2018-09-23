/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;

/**
 *
 * @author Hermanos-Jimenez
 */
public class ShortestPathDijkstra {

    //A utility function to find the vertex with minimum distance value
    //from the set of vertices not yet included in shortest path tree
    final int V = 9;
    int minDistance(int dist[], Boolean sptSet[]){
        //Initialize min value
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        
        for(int v = 0; v < V; v++){
            if(sptSet[v] == false && dist[v] <= min){
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }
    
    //A utility function to print the constructed distance array
    void printSolution(int dist[], int n){
        System.out.println("Vertex Distance From Source");
        for(int i = 0; i < V; i++){
            System.out.println(i + " tt " + dist[i]);
        }
    }
    
    //function that implements Dijkstra's single source shortest path
    //algorithm for a graph represented using adjacency matrix
    //representation
    void dijkstra(int grap[][], int src){
        int dist[] = new int[V]; //The output array. dist[i] will hold
                                 //the shortest distance from src to i
        
        //sptSet[i] will true if vertex i is included in shortest
        //path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];
        
        //Initialize all distances as INFINITE and stpSet[] as false
        for(int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        
        //Distance of source vertex from itself is always 0
        dist[src] = 0;
        
        
        //Find the shortest path for all vertices
        for(int count = 0; count < V - 1; count++){
            //Pick the minimun distance vertex from the set of vertices
            //not yet processed. u is always equal to src in first
            //iteration.
            int u = minDistance(dist, sptSet);
            
            //Mark the picket vertex as processed
            sptSet[u] = true;
            
            //Update dist value of adjacent vertices of
            //picket vertex.
            for(int v = 0; v < V; v++){
                //Update dist[v] only if is not in sptSet, there is an
                //edge from u to v, and total weight of path from src to
                //v through u is smaller than current value of dist[v]
                if(!sptSet[v] && grap[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + grap[u][v] < dist[v]){
                    dist[v] = dist[u] + grap[u][v];
                }
            }
            
            
            
        }
        
        //Print the constructed distance array
        printSolution(dist, V);
    }
    
    public static void main(String[] args) {
        //Let us create the example graph disscussed above
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                  {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                  {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0}
                                 };
        ShortestPathDijkstra t = new ShortestPathDijkstra();
        t.dijkstra(graph, 0);
    }
    
}
