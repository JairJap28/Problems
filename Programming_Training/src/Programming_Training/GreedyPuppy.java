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
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class GreedyPuppy {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            int t = lea.nextInt();
            
            for(int i = 0; i < t; i++){
                int n = lea.nextInt();
                int k = lea.nextInt();
                
                int aux, max = 0;
                
                for(int j = 1; j < k; j++){
                    aux = n % j;
                    if(aux > max) max = aux;
                }
                
                so.println(max);
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
