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
public class SumsInATriangle {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            
            int t = lea.nextInt();
            for(int k = 0; k < t; k++){
                int n = lea.nextInt();
            
                int triangle [][] = new int[n][n];

                for(int i = 0; i < n; i++){
                    for(int j = 0; j <= i; j++){
                        triangle[i][j] = lea.nextInt();
                    }
                }

                for(int i = n - 1; i >= 1; i--){
                    for(int j = 0; j < i; j++){
                        if(triangle[i][j] > triangle[i][j + 1]){
                            triangle[i - 1][j] = triangle[i - 1][j] + triangle[i][j];
                        }
                        else{
                            triangle[i - 1][j] = triangle[i - 1][j] + triangle[i][j + 1];
                        }
                    }
                }
                so.println(triangle[0][0]);
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
