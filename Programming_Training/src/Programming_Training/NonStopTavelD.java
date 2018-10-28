// Implemented with Dejkstra
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

public class NonStopTavelD {

    
    static int v,e;
    static int MAX = 11;
    static ArrayList<Node> ady[] = new ArrayList[MAX];
    static int marked[] = new int[MAX];
    static long distance[] = new long[MAX];
    static int prev[] = new int[MAX];
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here.
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            
            int counter = 1;
            
            while(true){
                int NI = lea.nextInt(); //Number of intersections
                if(NI == 0) break;
                MAX = v = NI;
                init();

                for(int i = 1; i <= NI; i++){
                    int subI = lea.nextInt(); //number of intersection with the respective point

                    for(int j = 0; j < subI; j++){
                        int arrival = lea.nextInt();
                        int delay = lea.nextInt();
                        ady[i].add(new Node(arrival, delay));
                    }
                }

                int start = lea.nextInt();
                int end = lea.nextInt();

                dijkstra(start);
                so.println("Case " + counter + ": Path = " + path(end) + "; " + distance[end] + " second delay");
                counter++;
            }
        }
    }
    
    static void init(){
        long max = Long.MAX_VALUE;
        for(int j = 0; j <= v; j++){
            marked[j] = 0;
            prev[j] = -1;
            distance[j] = max;
            ady[j] = new ArrayList<>();
        }
    }
    
    static void dijkstra(int s){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        distance[s] = 0;
        int actual , j, adjacent;
        long weight;
        Node x;
        
        while(pq.size() > 0){
            actual = pq.peek().adjacent;
            if(marked[actual] == 0){
                marked[actual] = 1;
                for(j = 0; j < ady[actual].size(); j++){
                    adjacent = ady[actual].get(j).adjacent;
                    weight = ady[actual].get(j).cost;
                    if(marked[adjacent] == 0){
                        if(distance[adjacent] > distance[actual] + weight){
                            distance[adjacent] = distance[actual] + weight;
                            prev[adjacent] = actual;
                            pq.add(new Node(adjacent, distance[adjacent]));
                        }
                    }
                }
            }
            pq.poll();
        }
    }
    
    static String path(int t){
        String r = "";
        while(prev[t] != -1){
            r = " " + t + r;
            t = prev[t];
        }
        if(t != -1){
            r = t + r;
        }
        return r;
    }
    
    
    static class Node implements Comparable<Node>{
        
        public int adjacent;
        public long cost;
        
        public Node(int ady, long c){
            this.adjacent = ady;
            this.cost = c;
        }
        
        @Override
        public int compareTo(Node o) {
            if(this.cost >= o.cost){
                return 1;
            }
            else{
                return -1;
            }
        }
        
    }
    
    static class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        
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
    
}
