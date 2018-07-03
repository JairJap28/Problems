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
public class ChefAndFruits {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            
            int casos = lea.nextInt();
            for(int i = 0; i < casos; i++){
                int datos[] = new int[2];
                datos[0] = lea.nextInt();
                datos[1] = lea.nextInt();
                int K = lea.nextInt();

                datos = operar(datos, K);
                int dif = 0;

                if(datos[0] != datos[1]){
                    int min = Math.min(datos[0], datos[1]);
                    int max = Math.max(datos[0], datos[1]);
                    dif = max - min;
                }

                so.println(dif);
            }
        }
    }
    
    public static int[] operar(int a[], int coin){
        
        if(a[0] > a[1] && coin > 0){
            a[1]++;
            coin--;
        }
        else if(a[1] > a[0] && coin > 0){
            a[0]++;
            coin--;
        }
        if(coin > 0 && a[0] != a[1]) operar(a, coin);
        return a;
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
