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
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class ChefAndDolls {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            int cases = lea.nextInt();
            
            for (int t = 0; t < cases; t++) {
                HashMap<Integer, Integer> dolls = new HashMap<>();
            
                int size = lea.nextInt();
                for (int i = 0; i < size; i++) {
                    int aux = lea.nextInt();
                    if(dolls.containsKey(aux)) dolls.put(aux, dolls.get(aux) + 1);
                    else dolls.put(aux, 1);
                }

                for (Map.Entry<Integer, Integer> entry : dolls.entrySet()) {
                    Integer key = entry.getKey();
                    Integer value = entry.getValue();

                    if(value % 2 == 1){
                        so.println(key);
                        break;
                    }
                }
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
