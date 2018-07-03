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
public class CopsAndTheThiefDevu {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    static boolean check[] = new boolean[101];
    static int speed;
    static int start;
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            
            int cases = lea.nextInt();
            
            for (int t = 0; t < cases; t++) {
                int M = lea.nextInt();
                int x = lea.nextInt();
                int y = lea.nextInt();

                Arrays.fill(check, false);

                speed = x * y;
                int sum = 0;
                int location;

                for (int i = 0; i < M; i++) {
                    start = lea.nextInt();
                    fillStraight();
                    fillPrevious();
                }

                int counter = 0;
                for (int i = 1; i <= 100; i++) {
                    if(!check[i]) counter++;
                }

                so.println(counter);    
            }
            
            
        }
    }
    
    static void fillStraight(){
        int i = 0;
        int auxStart = start;
        while(auxStart <= 100 && i <= speed){
            check[auxStart] = true;
            auxStart++;
            i++;
        }
    }
    
    static void fillPrevious(){
        int i = 0;
        int auxStart = start;
        while(auxStart >= 1 && i <= speed){
            check[auxStart] = true;
            auxStart--;
            i++;
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
