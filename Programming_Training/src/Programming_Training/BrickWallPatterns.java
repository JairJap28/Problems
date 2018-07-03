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
public class BrickWallPatterns {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            int n = lea.nextInt();
            
            while(n != 0){
                int numbers[] = new int[n + 1];
                numbers[0] = numbers[1] = 1;

                for (int i = 2; i <= n; i++) {
                    numbers[i] = numbers[i - 1] + numbers[i - 2];
                }

                so.println(numbers[n]);
                
                n = lea.nextInt();
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
