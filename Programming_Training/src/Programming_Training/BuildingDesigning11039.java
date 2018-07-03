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
import java.util.TreeMap;

/**
 *
 * @author Hermanos-Jimenez
 */
public class BuildingDesigning11039 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            
            int cases = lea.nextInt();
            for (int t = 0; t < cases; t++) {
                int nFloors = lea.nextInt();
                HashMap<Integer, Character> conditions = new HashMap<>();

                for (int i = 0; i < nFloors; i++) {
                    int aux = lea.nextInt();
                    if(aux > 0) conditions.put(aux, '+');
                    else conditions.put(Math.abs(aux), '-');
                }

                Map<Integer, Character> orden = new TreeMap<>(conditions);
                int i = 0;
                int counter = 0;
                int tam = 0;
                char color = 0;
                for (Map.Entry<Integer, Character> entry : orden.entrySet()) {
                    Integer key = entry.getKey();
                    Character value = entry.getValue();

                    if(i == 0){
                        tam = key;
                        color = value;
                        i++;
                        counter++;
                    }
                    else if(key > tam && value != color){
                        tam = key;
                        color = value;
                        counter++;
                    }
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
