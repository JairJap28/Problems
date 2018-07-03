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
public class Brackets {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            int cases = lea.nextInt();
            for (int t = 0; t < cases; t++) {
                String in = lea.next();
                int balance = balance(in);
                for (int i = 0; i < balance; i++) {
                    so.print("(");
                }
                for (int i = 0; i < balance; i++) {
                    so.print(")");
                }
                so.println("");
            }
        }        
    }
    
    static int balance(String in){
        int balance = 0;
        int max_balance = 0;
        for (int i = 0; i < in.length(); i++) {
            if(in.charAt(i) == '(') balance++;
            if(in.charAt(i) == ')') balance--;
            
            max_balance = Math.max(max_balance, balance);
        }
        return max_balance;
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
