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
public class CuttingRecipes {

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
                int numbers[] = new int[n];
                for(int i = 0; i < n; i++){
                    numbers[i] = lea.nextInt();
                }

                int gcd = findGcdArray(numbers);

                for(int i = 0; i < n; i++){
                    numbers[i] /= gcd;
                }

                for(int i = 0; i < n; i++){
                    so.print(numbers[i] + " ");
                }
                so.println();
            }
        }
    }
    
    public static int findGcdArray(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        while (min > 1) {
            int i = 0, s = 0;
            while (i < arr.length) {
                s += arr[i] % min;
                i++;
            }
            if (s == 0) {
                return min;
            }
            min--;
        }
        return 1;
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
