
package Programming_Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Wormholes {
     
    public Wormholes() throws IOException {
        Scanner sc = new Scanner();
        int cases = sc.nextInt();
        for(int c = 0; c < cases; c++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            Graph graph = new Graph(n, m);

            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int t = sc.nextInt();

                graph.edge[i].src = x;
                graph.edge[i].dest = y;
                graph.edge[i].weight = t;
            }

            boolean flag = graph.BellmanFor(graph, 0);
            if(flag){
                System.out.println("possible");
            }
            else{
                System.out.println("not possible");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Wormholes();
    }
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int spaces = 0;
        
        String nextLine() throws IOException{
            if(spaces > 0){
                spaces--;
                return "";
            }
            else if(st.hasMoreTokens()){
                StringBuilder out = new StringBuilder();
                while(st.hasMoreTokens()){
                    out.append(st.nextToken());
                    if(st.countTokens() > 0){
                        out.append(" ");
                    }
                }
                return out.toString();
            }
            return br.readLine();
        }
        
        String next() throws IOException{
            spaces = 0;
            while(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        boolean hasNext() throws IOException{
            while(!st.hasMoreTokens()){
                String line = br.readLine();
                if(line == null){
                    return false;
                }
                if(line.equals("")){
                    spaces++;
                }
                st = new StringTokenizer(line);
            }
            return true;
        }
        
        int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
        
        long nextLong() throws IOException{
            return Long.parseLong(next());
        }
    }
    
    class Graph{
        class Edge{
            int src;
            int dest;
            int weight;

            public Edge() {
            }
        };
        
        int V;
        int E;
        Edge edge[];

        //Create a graph with V vertices and E edges
        public Graph(int v, int e) {
            V = v;
            E = e;
            edge = new Edge[e];
            for(int i = 0; i < e; ++i){
                edge[i] = new Edge();
            }
        }
        
        //The main function finds shortest distances from src 
        //to all other vertices using Bellman-Ford algortithm. The
        //function also detects negative weight cycles
        boolean BellmanFor(Graph graph, int src){
            int V = graph.V;
            int E = graph.E;
            int dist[] = new int[V];
            
            //Step 1: Initialize distances from src to all other
            //vertices as INFINITE
            for(int i = 0; i < V; ++i){
                dist[i] = Integer.MAX_VALUE;
            }
            dist[src] = 0;
            
            //Step 2: Relax all edges |V| - 1 times. A simple
            //shortest path from src to any other vertex can
            //have at-most |V| - 1 edges
            for(int i = 1; i < V; ++i){
                for(int j = 0; j < E; ++j){
                    int u = graph.edge[j].src;
                    int v = graph.edge[j].dest;
                    int weight = graph.edge[j].weight;
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]){
                        dist[v] = dist[u] + weight;
                    }
                }
            }
            
            //Step 3: Check for negative-weight cycles. The above 
            //step guarantees shortest distance if graph doesn't 
            //contain negative weight cycle. If we get a shorter
            //path, then there is a cycle
            for(int j= 0; j < E; ++j){
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    //System.out.println("Graph contains negative weight cycle");
                    return true;
                }
            }
            //printArr(dist, V);
            return false;
        }
        
        /*void printArr(int dist[], int V){
            System.out.println("Vertex      Distance from source");
            for(int i = 0; i < V; ++i){
                System.out.println(i + "\t\t" + dist[i]);
            }
        }*/
    }

}
