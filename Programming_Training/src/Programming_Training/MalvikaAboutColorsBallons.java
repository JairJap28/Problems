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
public class MalvikaAboutColorsBallons {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            
            int cases = lea.nextInt();
            for (int j = 0; j < cases; j++) {
                String in = lea.next();
                int a = 0, b = 0;

                for (int i = 0; i < in.length(); i++) {
                    if(in.charAt(i) == 'a') a++;
                    else b++;
                }

                so.println(Math.min(a, b));
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
