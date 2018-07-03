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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class circular {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    static int MAX = 1000001;
    static ArrayList<Integer> primes = new ArrayList<>();
    static boolean sieve[] = new boolean[MAX + 5];
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            int numeros[] = {2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97, 113, 131, 197, 199, 311,
                337, 373, 719, 733, 919, 971, 991, 1193, 1931, 3119, 3779, 7793, 7937, 9311, 9377, 
                11939, 19391, 19937, 37199, 39119, 71993, 91193, 93719, 93911, 99371, 193939, 199933, 
                319993, 331999, 391939, 393919, 919393, 933199, 939193, 939391, 993319, 999331};
            
            calcularPrimes();
            so.println("Tamaño arreglo = " + primes.size());
            
            while(true){
                int start = lea.nextInt();
                if(start == -1) break;
                int end = lea.nextInt();
                int contador = 0;
                for(int i = 0; i < numeros.length; i++){
                    if(numeros[i] >= start && numeros[i] <= end ){
                        contador++;
                    }
                }
                //calcularPrimes();
                if(contador == 0) so.println("No Circular Primes.");
                else if(contador == 1) so.println("1 Circular Prime.");
                else if(contador > 1) so.println(contador + " Circular Primes.");
            }
        }
    }
    
    static void calcularPrimes(){
        sieve[0] = sieve[1] = true;
        int i;
        for(i = 2; i * i <= MAX; ++i){
            if(!sieve[i]){
                if(checkCircularPrime(i + "")) primes.add(i);
                for(int j = i * i; j <= MAX; j += i)
                    sieve[j] = true;
            }
        }
        for(; i <= MAX; i++){
            if(!sieve[i]){
                if(checkCircularPrime(i + "")) primes.add(i);
            }
        }
    }
    
    static boolean checkCircularPrime(String i){
        StringBuilder a = new StringBuilder();
        String aux;
        for(int j = 0; j < i.length(); j++){
            a.append(i.substring(1, i.length())).append(i.substring(0,1));
            aux = a.toString();
            i = aux;
            if(!new BigInteger(aux).isProbablePrime(1)) return false;
        }
        return true;
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
