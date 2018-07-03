/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class BookBorders {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        
        String in = lea.nextLine();
        int a = lea.nextInt();
        int b = lea.nextInt();
        
        String words[] = in.split(" ");
        
        int tam;
        int auxCounter;
        int lines;
        
        
        for (int i = a; i <= b; i++) {
            tam = 0;
            auxCounter = 0;
            lines = 0;
            for (String word : words) {
                if(auxCounter + word.length() > i){
                    lines = 0;
                    auxCounter = word.length();
                    if(auxCounter < i)  auxCounter++;
                }
                else{
                    auxCounter += word.length();
                    if(auxCounter < i) auxCounter++;
                }

                if(lines == 0){
                    lines++;
                    if(auxCounter < i) tam += word.length() + 1;
                    else tam += word.length();
                }
            }

            System.out.println(tam - 1);
        }
    }
    
    static class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int espacios = 0;
        
        public String nextLine() throws IOException{
            if(espacios > 0){
                espacios--;
            }
            else if(st.hasMoreTokens()){
                StringBuilder salida = new StringBuilder();
                while(st.hasMoreTokens()){
                    salida.append(st.nextToken());
                    if(st.countTokens() > 0){
                        salida.append(" ");
                    }
                }
                return salida.toString();
            }
            return br.readLine();
        }
        
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
