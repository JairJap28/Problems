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
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class TurboSort {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            ArrayList<Integer> numbers = new ArrayList<>();
            
            int n = lea.nextInt();
            for (int i = 0; i < n; i++) {
                numbers.add(lea.nextInt());
            }
            Collections.sort(numbers);
            
            numbers.stream().forEach((number) -> {
                so.println(number);
            });
        }
    }
    
    static int[] Quicksort(int matrix[], int a, int b){
        int aux[] = new int[matrix.length];
        int buf;
        int from = a;
        int to = b;
        int pivot = matrix[(from + to) / 2];
        do{
            while(matrix[from] < pivot) from++;
            while(matrix[to] > pivot) to--;
            if(from <= to){
                buf = matrix[from];
                matrix[from] = matrix[to];
                matrix[to] = buf;
                from++; to--;
            }
        }while(from <= to);
        if(a <to) Quicksort(aux, a, to);
        if(from < b) Quicksort(aux, from, b);
        
        return aux;
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
