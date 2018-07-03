/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class UnreachebleNodes {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    static int v;
    static int MAX = 100005;
    static ArrayList<Integer> ady[] = new ArrayList[MAX];
    static ArrayList<Integer> store = new ArrayList<>();
    static boolean marked[] = new boolean[MAX];
        
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            int N = lea.nextInt();
            int M = lea.nextInt();
            v = N;
            init();
            for(int i = 0; i < M; i++){
                int a = lea.nextInt();
                int b = lea.nextInt();
                ady[a].add(b);
                ady[b].add(a);
            }
            
            int resource = lea.nextInt();
            
            dfs(resource);
            
            int counter = 0;
            for(int i = 0; i <= v; i++){
                if(marked[i]) counter++;
            }
            so.println(N - counter);
        }
    }
    
    static void init(){
        for(int j = 0; j <= v; j++){
            marked[j] = false;
            ady[j] = new ArrayList<>();
        }
    }
    
    static void dfs(int s){
        marked[s] = true;
        int i, next;
        for(i = 0; i < ady[s].size(); i++){
            next = ady[s].get(i);
            if(!marked[next]){
                dfs(next);
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
