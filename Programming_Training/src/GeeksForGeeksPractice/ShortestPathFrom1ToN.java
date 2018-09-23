/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeeksForGeeksPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class ShortestPathFrom1ToN {

    int V;
    int E;
    int MAX = 50005;
    ArrayList<Node> ady[] = new ArrayList[MAX];
    boolean marked[] = new boolean[MAX];
    long distance[] = new long[MAX];
    
    void dijkstra(int s){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        distance[s] = 0;
        
        while(pq.size() > 0){
            int actual = pq.peek().adjacent;
            if(!marked[actual]){
                marked[actual] = true;
                for(int j = 0; j < ady[actual].size(); j++){
                    int adjacent = ady[actual].get(j).adjacent;
                    long weight = ady[actual].get(j).cost;
                    if(!marked[adjacent]){
                        if(distance[adjacent] > distance[actual] + weight){
                            distance[adjacent] = distance[actual] + weight;
                            pq.add(new Node(adjacent, distance[adjacent]));
                        }
                    }
                }
            }
            pq.poll();
        }
    }
    
    void init(){
        for(int i = 0; i < V; i++){
            ady[i] = new ArrayList<>();
            marked[i] = false;
            distance[i] = Long.MAX_VALUE;
        }
    }
    
    public ShortestPathFrom1ToN() throws IOException {
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        for(int cases= 0; cases < t; cases++){
            V = sc.nextInt() + 1;
            init();

            for(int i = 1; i < V; i++){
                if(i + 1 < V){
                    ady[i].add(new Node(i + 1, 1));
                }
                if(i * 3 < V){
                    ady[i].add(new Node(i * 3, 1));
                }
            }
            dijkstra(1);
            System.out.println(distance[V - 1]);
        }
        
        
        
    }
     
    
    
    public static void main(String[] args) throws IOException {
        new ShortestPathFrom1ToN();
    }
    
    class Node implements Comparable<Node>{
        public int adjacent;
        public long cost;

        public Node(int adjacent, long cost) {
            this.adjacent = adjacent;
            this.cost = cost;
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
        
        String next() throws IOException{
            while(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
    }
    
}
