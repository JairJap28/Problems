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
public class CatsAndDogs {
    static long C;
    static long D;
    static long L;

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            
            int t = lea.nextInt();
            for (int cases = 0; cases < t; cases++) {
                C = lea.nextLong();
                D = lea.nextLong();
                L = lea.nextLong();

                if(checkDogs()){
                    if(checkCats()) so.println("yes");
                    else so.println("no");
                }
                else so.println("no");
            }
            
            
            
            
        }
    }
    
    static boolean checkDogs(){
        
        long aux = D * 4;
        if((L - aux) >= 0){
            L -= aux;
            return true;
        }
        return false;
    }
    
    static boolean checkCats(){
        long aux = C * 4;
        long dif = 0;
        if(L > 0){
            if(L - aux >= 0){
                return true;
            }
            else{
                dif = Math.abs(L - aux);
            }
        }
        else{
            long aux2 = C;
            if(C % 2 == 1){
                aux2 = C + 1;
            }
            
            aux2 = aux2 / 2;
            
            if(aux2 <= D) return true;
        }
        
        if(dif > 0){
            long amountcats = dif / 4;
            if(amountcats <= D) return true;
        }
        
        return false;
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
        
        public long nextLong() throws IOException{
            return Long.parseLong(next());
        }
    }
    
}
