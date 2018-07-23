/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class CountingSort {

    public CountingSort() throws IOException {
        Scanner lea = new Scanner();
        int n = lea.nextInt();
        ArrayList<Integer> num = new ArrayList<>();
        
        int higher = 0;
        
        for (int i = 0; i < n; i++) {
            int aux = lea.nextInt();
            higher = Math.max(aux, higher);
            num.add(aux);
        }
        
        int numbers[] = new int[higher + 1];
        for (int i = 0; i < num.size(); i++) {
            numbers[num.get(i)]++;
        }
        
        for (int i = 1; i <= higher; i++) {
            numbers[i] = numbers[i - 1] + numbers[i];
        }
        
        int out[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            out[numbers[num.get(i)]] = num.get(i);
            numbers[num.get(i)]--;
        }
        
        for (int i = 0; i <= n; i++) {
            if(num.indexOf(out[i]) >= 0) System.out.print(out[i] + " ");
        }
        System.out.println("");
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new CountingSort();
        
    }
    
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        
        String next() throws IOException{
            while(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
    }
    
}
