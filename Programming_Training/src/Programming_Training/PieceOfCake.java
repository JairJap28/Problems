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
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class PieceOfCake {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            
            int casos = lea.nextInt();
            for(int j = 0; j < casos; j++){
                String s = lea.next();
                HashMap<Character, Integer> datos = new HashMap<>();
                int mayor = 0;
                for(int i = 0; i < s.length(); i++){
                    if(datos.containsKey(s.charAt(i))){
                        datos.put(s.charAt(i), datos.get(s.charAt(i)) + 1);
                    }
                    else{
                        datos.put(s.charAt(i), 1);
                    }
                }

                int a = Collections.max(datos.entrySet(), Map.Entry.comparingByValue()).getValue();

                if(s.length() - a == a) so.println("YES");
                else so.println("NO");
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
