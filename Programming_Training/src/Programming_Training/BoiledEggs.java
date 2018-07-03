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
public class BoiledEggs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            
            int cases = lea.nextInt();
            for (int t = 0; t < cases; t++) {
                int n = lea.nextInt();
                int p = lea.nextInt();
                int q = lea.nextInt();

                int aux = 0;
                int counter = 0;

                for (int i = 0; i < n; i++) {
                    int in = lea.nextInt();
                    if(q - in >= 0 && p - 1>= 0){
                        counter++;
                        q -= in;
                        p--;
                    }
                }

                so.println("Case " + (t + 1) + ": " + counter);
            }
            
            
            
        }
    }
    
    static class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int espacios = 0;
        
        public String next() throws IOException{
            while(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        public boolean hasNext() throws IOException{
            while(!st.hasMoreTokens()){
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
        
        public long nextLong() throws IOException{
            return Long.parseLong(next());
        }
    }
    
}
