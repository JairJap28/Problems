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
public class TheTouristGuide {

    /**
     * @param args the command line arguments
     */
    
    static int v,e;
    static int MAX = 1002;
    static int datos[][] = new int[MAX][MAX];
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            int counter = 0;
            while(true){
                int N = lea.nextInt(); //cities
                int R = lea.nextInt(); //roads
                if(N == 0 && R == 0) break;
                MAX = v = N;
                init(N);
                for(int i = 0; i < R; i++){
                    int a = lea.nextInt();
                    int b = lea.nextInt();
                    int weight = lea.nextInt();
                    datos[a][b] = datos[b][a] = weight - 1;
                }

                int source = lea.nextInt();
                int arrive = lea.nextInt();
                int passengers = lea.nextInt();

                for(int k = 1; k <= N; k++){
                    for(int i = 1; i <= N; i++){
                        for(int j = 1; j <= N; j++){
                            if(datos[k][j] != Integer.MIN_VALUE && i != j)
                            datos[i][j] = Math.max(datos[i][j], Math.min(datos[i][k], datos[k][j]));
                        }
                    }
                }

                int trip = passengers / datos[source][arrive];
                if(trip * datos[source][arrive] < passengers) trip++;

                so.println("Scenario #" + (counter + 1));
                so.println("Minimum Number of Trips = " + trip + "\n");
                counter++;
            }
            
            
        }
    }
    
    static void init(int n){
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                datos[i][j] = -1;
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
