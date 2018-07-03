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
public class CompleteNaebbiracSequence {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            while (lea.hasNext()) {
                int k = lea.nextInt();
                int n = lea.nextInt();

                int can = (n%k == 0)? (n / k): ((n+1) % k == 0)? ((n+1) / k): ((n - 1) % k == 0)? ((n - 1) / k): -1;
                int numbers[] = new int[k + 1];
                for (int i = 0; i < n; i++) 
                    numbers[lea.nextInt()]++;

                if(can != -1){
                    int mas = 0, menos = 0, diferencia = 0;
                    for (int i = 1; i <= k; i++) {
                        if (numbers[i] - can != 0) {
                            if (numbers[i] - can > 0) {
                                if (numbers[i] - can == 1){
                                    menos = i;
                                    diferencia++;
                                }
                                else{
                                    diferencia = 10;
                                    break;
                                }
                            }
                            else if (numbers[i] - can < 0) {
                                if (numbers[i] - can == -1){
                                    mas = i;
                                    diferencia++;
                                }
                                else{
                                    diferencia = 10;
                                    break;
                                }
                            }
                            else diferencia++;
                        }
                    }

                    if(diferencia <= 2){
                        if(diferencia == 2){
                            System.out.println("-" + menos + " +" + mas);
                        }
                        else{
                            if(diferencia == 1){
                                if(menos != 0) System.out.println("-" + menos);
                                if(mas != 0) System.out.println("+" + mas);
                            }
                        }
                    }
                    else System.out.println("*");

                }
                else System.out.println("*");
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
        
        public int nextInt() throws IOException{
            return Integer.parseInt(next());
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
    }

}
