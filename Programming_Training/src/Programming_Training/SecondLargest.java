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
public class SecondLargest {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            
            int t = lea.nextInt();
            for(int T = 0; T < t; T++){
                int a = lea.nextInt();
                int b = lea.nextInt();
                int c = lea.nextInt();
                int may = 0;

                if((a > b && b > c) || (c > b && b > a)) may = b;
                else if((b > a && a > c) || (c > a && a > b)) may = a;
                else if((a > c && c > b) || (b > c && c > a)) may = c;

                so.println(may);
            }
        }
    }
    
    static class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int espacios = 0;
        
        public String next() throws IOException{
            espacios = 0;
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
