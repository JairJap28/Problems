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
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class ChefAndColoring {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            
            int cases = lea.nextInt();
            for (int t = 0; t < cases; t++) {
                int n = lea.nextInt();

                String in = lea.next();

                int r = 0, g = 0, b = 0;
                
                for (int i = 0; i < n; i++) {
                    switch (in.charAt(i)) {
                        case 'R':
                            r++;
                            break;
                        case 'G':
                            g++;
                            break;
                        default:
                            b++;
                            break;
                    }
               }
                
               if(r >= g && r >= b) so.println(b + g);
               else if(g >= r && g >= b)  so.println(r + b);
               else so.println(r + g);
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
