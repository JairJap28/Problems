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
public class TheSmallestPair {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            
            int t = lea.nextInt();
            for(int j = 0; j < t; j++){
                int n = lea.nextInt();
                int numbers[] = new int[n];
                int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
                for(int i = 0; i < n; i++){
                    numbers[i] = lea.nextInt();
                    if(numbers[i] < min1){
                        min2 = min1;
                        min1 = numbers[i];
                    }
                    else if(numbers[i] < min2){
                        min2 = numbers[i];
                    }
                }   
                so.println(min1 + min2);
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
