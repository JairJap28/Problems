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
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class NodesAtEvenDistance {
    
    int MAX = 100005;
    ArrayList<Integer> data[];
    ArrayList<Node> nodes; 
    boolean visited[];
    int v;
    int x;
    int y;
    int can;
    
    void init(){
        for(int i = 0; i <= v; i++){
            data[i] = new ArrayList<>();
            visited[i] = false;
        }
    }
    
    void dfs(int s, int d, int can){
        visited[d] = true;
        for(int i = 0; i < data[d].size(); i++){
            int next = data[d].get(i);
            if(!visited[next]){
                dfs(s, next, can + 1);
            }
        }
        if(can % 2 == 0 && s != d){
            nodes.add(new Node(s, d, can));
        }
    }
    
    
    public NodesAtEvenDistance() throws IOException {
        Scanner sc = new Scanner();
        
        int t = sc.nextInt();
        for(int cases = 0; cases < t; cases++){
            v = sc.nextInt();
            data = new ArrayList[v + 1];
            nodes = new ArrayList<>();
            visited = new boolean[v + 1];
            init();
            can = 0;

            for(int i = 0; i < v - 1; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                data[a].add(b);
                data[b].add(a);
            }
            
            dfs(1, 1, 0);
            
            System.out.println(nodes.size());
        }
        
        
    }
    
    public static void main(String[] args) throws IOException {
        new NodesAtEvenDistance();
    }
    
    class Node{
        int source;
        int dest;
        int weight;

        public Node(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int spaces = 0;
        
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
