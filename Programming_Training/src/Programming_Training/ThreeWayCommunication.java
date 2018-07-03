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
public class ThreeWayCommunication {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            
            int t = lea.nextInt();
            
            for(int u = 0; u < t; u++){
                int r = lea.nextInt();
                int points[][] = new int[3][2];

                for(int i = 0; i < 3; i++){
                    points[i][0] = lea.nextInt();
                    points[i][1] = lea.nextInt();
                }

                so.println(check(points, r * r));
            }
        }
    }
    
    public static String check(int[][] a, int r){ //r ya va al cuadrado
        
        int aX = a[0][0], aY = a[0][1];
        int bX = a[1][0], bY = a[1][1];
        int cX  = a[2][0], cY = a[2][1];
        
        int counter = 0;
        
        if(Math.pow((bX - aX), 2.0) + (Math.pow((bY - aY), 2.0)) <= r) counter++;
        if(Math.pow((cX - aX), 2.0) + (Math.pow((cY - aY), 2.0)) <= r) counter++;
        if(Math.pow((bX - cX), 2.0) + (Math.pow((bY - cY), 2.0)) <= r) counter++;
        
        if(counter >= 2) return "yes";
        else return "no";
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
