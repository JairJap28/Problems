package Programming_Training;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class AlmostShortestPath {
    
    int v, e;
    int MAX = 100005;
    ArrayList<Node> ady[] = new ArrayList[MAX];
    int market[][] = new int[505][505]; //Forbidden
    long distance[] = new long[505]; //shortest
    ArrayList<Integer> parent[] = new ArrayList[MAX];
    
    long shortPath = 0;
    int index;
    int node;
    int t;
    int s;

    public AlmostShortestPath() throws IOException {
        Scanner lea = new Scanner();
        
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            while(true){
                int n = lea.nextInt();
                int m = lea.nextInt();
                if(n == 0 && m == 0) break;
                
                MAX = n;
                v = n;
                init();

                s = lea.nextInt(); //from
                t = lea.nextInt(); //to

                for (int i = 0; i < m; i++) {
                    int u = lea.nextInt();
                    int v = lea.nextInt();
                    int p = lea.nextInt();
                    ady[u].add(new Node(v, p));
                }

                dijkstra(s);
                long first = distance[t];
                long second = Long.MAX_VALUE;
                if(first < Long.MAX_VALUE){
                    removeEdges(s, t);
                    dijkstra(s);
                    second = distance[t];
                }
                if(second == Long.MAX_VALUE) second = -1;
                
                so.println(second);
            }
        }
    }
    
    
    void removeEdges(int s, int t){
        if(s == t) return;
        for (int i = 0; i < parent[t].size(); i++) {
                market[parent[t].get(i)][t] = 1;
            removeEdges(s, parent[t].get(i));
        }
        return;
    }
    
    void init(){
        for (int i = 0; i < v; i++) {
            ady[i] = new ArrayList<>();
            parent[i] = new ArrayList<>();
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                market[i][j] = 0;
            }
        }
    }
    
    void dijkstra(int s){
        
        for (int i = 0; i < v; i++) 
            distance[i] = Long.MAX_VALUE;
        
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        distance[s] = 0;
        int actual, j, adjacent;
        long weight;
        
        while(pq.size() > 0){
            actual = pq.peek().adjacent;
            for (j = 0; j < ady[actual].size(); j++) {
                adjacent = ady[actual].get(j).adjacent;
                weight = ady[actual].get(j).cost;
                if(market[actual][adjacent] == 1) continue;
                if (distance[adjacent] > distance[actual] + weight) {
                    distance[adjacent] = distance[actual] + weight;
                    parent[adjacent].clear();
                    parent[adjacent].add(actual);
                    pq.add(new Node(adjacent, distance[adjacent]));
                }
                else if(distance[adjacent] == distance[actual] + weight) parent[adjacent].add(actual);
            }
            pq.poll();
        }
    }    
    
    class Node implements Comparable<Node>{
        
        public int adjacent;
        public long cost;

        public Node(int ady, long c) {
            this.adjacent = ady;
            this.cost = c;
        }
        
        @Override
        public int compareTo(Node o) {
            if (this.cost > o.cost) {
                return 1;
            }
            else{
                return -1;
            }
        }
        
    }

    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st =  new StringTokenizer("");
        
        public String next() throws IOException{
            while(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        public int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new AlmostShortestPath();
    }
    
}
