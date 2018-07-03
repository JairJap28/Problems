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
public class CeilAndRecept {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int t = Integer.parseInt(lea.next());
        
        for(int j = 0; j < t; j++){
            int p = Integer.parseInt(lea.next());
            int counter = 0;
            for(int i = 11; i >= 0; i--){
                int powTest = (int) Math.pow(2.0, (double) i);
                if(p - powTest >= 0){
                    p -= powTest;
                    i++;
                    counter++;
                }
            }
            so.println(counter);
        }
        so.close();
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
    }
    
}
