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
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class ILoveBigNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            
            while(lea.hasNext()){
                int n = lea.nextInt();
            
                BigInteger a = BigInteger.ONE;

                for (int i = 1; i <= n; i++) {
                    a = a.multiply(BigInteger.valueOf((long) i));
                }

                long sum = 0;

                while(!a.equals(BigInteger.ZERO)){
                    sum += a.mod(BigInteger.TEN).intValue();
                    a = a.divide(BigInteger.TEN);
                }

                so.println(sum);
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
    }
    
}
