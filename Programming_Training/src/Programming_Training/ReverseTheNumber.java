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
public class ReverseTheNumber {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int t = Integer.parseInt(lea.next());
        for(int i = 0; i < t; i++){
            StringBuilder in = new StringBuilder(lea.next());
            
            int out = Integer.parseInt((String) in.reverse().toString());
            so.println(out);
        }
       
        so.close();
    }
    
    //Este metodo es opcional, la disminución del tiempo es minima, más rapido teclear la otra forma
    /*public static int reverse(String in){ 
        int n = Integer.parseInt(in);
        int number = 0, aux;
        int tam = (int) Math.pow(10.0, (double) (in.length() - 1));
        while(n > 0){
            aux = n % 10;
            number += aux * tam;
            n /= 10;
            tam /= 10;
        }
        return number;
    }*/
    
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
