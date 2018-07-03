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
public class FarmerAndHisPlot {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            
            int cases = lea.nextInt();
            for (int i = 0; i < cases; i++) {
                int n = lea.nextInt();
                int m = lea.nextInt();

                int maxSide = mcd(n, m);

                int minimunPlots = (n * m) / (maxSide * maxSide); // (n * m) area of the whole rectangle;
                                                                  // (maxSide * maxSide) area of the minimum rectangle
                so.println(minimunPlots);                       
            }
        }
        
    }
    
    static int mcd(int a, int  b){
        int aux;
        while(b != 0){
            a %= b;
            aux = b;
            b = a;
            a = aux;
        }
        return a;
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
