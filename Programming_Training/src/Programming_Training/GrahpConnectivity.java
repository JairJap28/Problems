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
public class GrahpConnectivity {
    
    int v;
    int MAX = 30;
    ArrayList<Integer> ady[] = new ArrayList[MAX];
    boolean marked[] = new boolean[MAX];
    
    public GrahpConnectivity() throws IOException{
        Scanner lea = new Scanner();
        
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            int t = lea.nextInt();
            lea.nextLine();
            
            for (int cases = 0; cases < t; cases++) {
                String aux = lea.next();
                
                int tam = aux.charAt(0) - 'A' + 1;
                v = tam;
                init();

                while((aux = lea.nextLine()) != null && !aux.isEmpty()) {
                    int a = aux.charAt(0) - 'A';
                    int b = aux.charAt(1) - 'A';

                    ady[a].add(b);
                    ady[b].add(a);
                }

                int counter = 0;
                for (int i = 0; i < v; i++) {
                    if(!marked[i]){
                        dfs(i);
                        counter++;
                    }
                }

                so.println(counter);
                if(cases < t - 1) so.println("");
            }
        }        
    }
    
    void init(){
        for (int i = 0; i <= v; i++) {
            marked[i] = false;
            ady[i] = new ArrayList<>();
        }
    }
    
    void dfs(int s){
        marked[s] = true;
        int i, next;
        
        for (i = 0; i < ady[s].size(); i++) {
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
        int espacios = 0;
        
        public String nextLine() throws IOException{
            if(espacios > 0){
                espacios--;
                return "";
            }
            else if(st.hasMoreTokens()){
                StringBuilder salida = new StringBuilder();
                while (st.hasMoreElements()) {
                    salida.append(st.nextToken());
                    if(st.countTokens() > 0){
                        salida.append(" ");
                    }
                }
                return salida.toString();
            }
            return br.readLine();
        }
        
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new GrahpConnectivity();
    }
    
}
