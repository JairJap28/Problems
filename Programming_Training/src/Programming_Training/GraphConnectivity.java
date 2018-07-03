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
public class GraphConnectivity {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    static int v, e;
    static int MAX = 30;
    static ArrayList<Integer> ady[] = new ArrayList[MAX];
    static ArrayList<Integer> store = new ArrayList<>();
    static boolean marked[] = new boolean[MAX];
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            
        int casos = lea.nextInt();
        lea.nextLine();
        
        for(int k = 0; k < casos; k++){
            String tam = lea.next();
            v = tam.charAt(0) - 'A' + 1;
            init();
            
            String in;
            
            while((in = lea.nextLine()) != null && !in.isEmpty()){
                int a = in.charAt(0) - 'A';
                int b = in.charAt(1) - 'A';
                
                ady[a].add(b);
                ady[b].add(a);
            }
            
            int counter = 0;
            
            for(int i = 0; i < v; i++){
                if(!marked[i]){
                    dfs(i);
                    counter++;
                }
            }
            
            so.println(counter);
            if(k < casos - 1) so.println();
        }
            
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
        int i , next;
        
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
        int espacios = 0;
        
        public String nextLine() throws IOException{
            if(espacios > 0){
                espacios--;
                return "";
            }
            else if(st.hasMoreTokens()){
                StringBuilder salida = new StringBuilder();
                while(st.hasMoreTokens()){
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
            espacios = 0;
            while(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        public boolean hasNext() throws IOException{
            while(st.hasMoreTokens()){
                String linea = br.readLine();
                if(linea == null){
                    return false;
                }
                if(linea.equals("")){
                    espacios++;
                }
                st = new StringTokenizer(linea);
            }
            return true;
        }
        
        
        
        public int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
    }
}
