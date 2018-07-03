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
public class ChefAndSubArrays {

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner lea = new Scanner();
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            
            int cases = lea.nextInt();
            for (int t = 0; t < cases; t++) {
                int n = lea.nextInt();
                int numbers[] = new int[n];
                for (int i = 0; i < n; i++) {
                    numbers[i] = lea.nextInt();
                }

                int sum = 0;
                int  product = 1;
                int counter = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = i; j < n; j++) {
                        sum += numbers[j];
                        product *= numbers[j];

                        if(sum == product) counter++;
                    }
                    sum = 0;
                    product = 1;
                }

                so.println(counter);
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
