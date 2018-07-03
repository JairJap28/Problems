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
public class AncientCipher1339 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            
            while(lea.hasNext()){
                String cifred = lea.next();
                String original = lea.next();

                int c[] = new int[45];
                int o[] = new int[45];

                for (int i = 0; i < cifred.length(); i++) {
                    c[cifred.charAt(i) - 48]++;
                }

                for (int i = 0; i < original.length(); i++) {
                    o[original.charAt(i) - 48]++;
                }

                Arrays.sort(c);
                Arrays.sort(o);

                boolean flag = true;

                for (int i = 0; i < 45; i++) {
                    if(c[i] != o[i]){
                        flag = false;
                        break;
                    }
                }

                if(flag) so.println("YES");
                else so.println("NO");
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
