/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dominos {
    
    final int MAX = 1110000;
    
    int node;
    int edge;
    int color[] = new int[MAX];
    ArrayList<Integer> graph[] = new ArrayList[MAX];
    ArrayList<Integer> dpto = new ArrayList<>();
    int num;
    
    void dfs_visit(int u){
        color[u] = 1;
        for(int i = 0; i < graph[u].size(); i++){
            int v = graph[u].get(i);
            if(color[v] == 0){
                dfs_visit(v);
            }
        }
        dpto.add(u);
    }
    
    void dfs(){
        Arrays.fill(color, 0);
        for(int i = 1; i <= node; i++){
            if(color[i] == 0){
                dfs_visit(i);
            }
        }
    }
    
    void dfs2(){
        Arrays.fill(color, 0);
        int j = dpto.size() - 1;
        for(int i = j; i >= 0; i--){
            if(color[dpto.get(i)] == 0){
                dfs_visit(dpto.get(i));
                num++;
            }
        }
    }
    
    void init(){
        for(int i = 0; i <= node; i++){
            graph[i] = new ArrayList<>();
        }
    }
    
    public Dominos() throws IOException {
        Scanner sc = new Scanner();
        
        int t = sc.nextInt();
        for(int cases = 0; cases < t; cases++){
            num = 0;
            node = sc.nextInt();
            edge = sc.nextInt();
            init();
            for(int i = 1;i <= edge; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph[a].add(b);
            }

            dfs();
            dfs2();

            System.out.println(num);

            dpto.clear();
            init();
        }
        
        
    }
    
    public static void main(String[] args) throws IOException{
        new Dominos();
    }
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st  = new StringTokenizer("");
        
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
