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
public class AmbigousPermutations {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            
            while(true){
                int n = lea.nextInt();
                
                if(n == 0) break;
                
                int numbers[] = new int[n + 1];
                int auxNumers[] = new int[n + 1];
                    
                for(int i = 1; i <= n; i++){
                    int a = lea.nextInt();
                    numbers[i] = a;
                    auxNumers[a] = i;
                } 
                
                int counter = 0;
                for(int i = 0; i <= n; i++){
                    if(numbers[i] == auxNumers[i]) counter++;
                }
                
                if(counter == n + 1) so.println("ambiguous");
                else so.println("not ambiguous");
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
