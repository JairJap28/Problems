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
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class LightingAway {

    //Datos necesarios para la implementacion del DFS
    static int v, e;
    static int MAX = 100005;
    static ArrayList<Integer>[] ady = new ArrayList[MAX];
    static ArrayList<Integer> store = new ArrayList<>();
    static boolean marked[] = new boolean[MAX];
    
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            
            int casos = lea.nextInt();
            for(int h = 0; h < casos; h++){
                int N = lea.nextInt();
                int M = lea.nextInt();
                
                MAX = v = N;
                init();
                
                for(int i = 0; i < M; i++){
                    int a = lea.nextInt();
                    int b = lea.nextInt();
                    ady[a].add(b);
                }
                int aux = 0;
                for(int i = 1; i <= N; i++){
                    if(!marked[i]){
                        dfs(i);
                        store.add(i);
                    }
                }
                Arrays.fill(marked, false);
                aux = 0;
                for(int i = store.size() -1; i >= 0; i--){
                    if(!marked[store.get(i)]){
                        dfs(store.get(i));
                        aux++;
                    }
                }

                so.println("Case " + (h + 1) + ": " + aux);
                Arrays.fill(marked, false);
                store.clear();
            }
        }
    }
    
    //Implementacion algortimo busqueda en profundidad
    //Limpia las estructuras de datos
    static void init(){
        for(int j = 0; j <= v; j++){
            marked[j] = false;
            ady[j] = new ArrayList<>();
        }
    }
    
    
    //recibe el nodo inicial s
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
