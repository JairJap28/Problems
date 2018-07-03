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
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class CountSubArray {

    static long sortIn[];
    static long in[];
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            
            long t = lea.nextLong();
            for (int cases = 0; cases < t; cases++) {
                long n = lea.nextLong();
                in = new long[(int) n + 1];
                sortIn = new long[(int) n + 1];

                for (int i = 1; i <= n; i++) {
                    in[i] = lea.nextLong();
                    sortIn[i] = in[i];
                }

                Arrays.sort(sortIn);

                so.println(check(n));
            }
            
            
        }
    }
    
    static long check(long n){
        long a, b, previous;
        long counter = 0;
        boolean flag = true;
        for (long i = 1; i <= n; i++) {
            a = i;
            for (long k = i; k <= n; k++) {
                b = k;
                previous = in[(int) i];
                
                for (long j = a; j <= b; j++) {
                    if (previous > in[(int) j]) {
                        flag = false;
                        j = b;
                    }
                    else previous = in[(int) j];
                }

                if (flag) {
                    counter++;
                }
                else flag = true;
            } 
        }
        return counter;
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
        
        public Long nextLong() throws IOException{
            return Long.parseLong(next());
        }
    }
    
}
