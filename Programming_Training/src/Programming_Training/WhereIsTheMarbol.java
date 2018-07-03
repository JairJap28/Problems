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
public class WhereIsTheMarbol {

    public WhereIsTheMarbol() throws IOException {
        Scanner lea = new Scanner();
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            
            int t = 1;
            
            while(true){
                         
                int n = lea.nextInt();
                int q = lea.nextInt();
                
                if(n == 0 && q == 0) break;
                
                int data[] = new int[n];

                for (int i = 0; i < n; i++) {
                    data[i] = lea.nextInt();
                }

                data = quickSort(data, 0, n - 1);
                
                System.out.println("CASE# " + t + ":");
                
                for (int i = 0; i < q; i++) {
                    int aux = lea.nextInt();
                    int index = -1;
                    
                    for (int j = 0; j < n; j++) {
                        if(data[j] == aux){
                            index = j;
                            break;
                        }
                    }
                    
                    if(index == -1) System.out.println(aux + " not found");
                    else System.out.println(aux + " found at " + (index + 1));
                }
                t++;
            }  
        }
    }
    
    int[] quickSort(int arr[], int low, int high){
        
        if(low < high){
            int pi = partition(arr, low, high);
            
            quickSort(arr, low, pi - 1); //searching on the left
            quickSort(arr, pi + 1, high); //searching on the right
        }
        
        return arr;
    }
    
    int partition(int arr[], int low, int high){
        
        int pivot = arr[high];
        int i = low - 1;
        int j;
        
        for (j = low; j <= high -1; j++) {
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[j];
        arr[j] = temp;
        
        
        return (i + 1);
    }
    
    
    class Scanner{
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new WhereIsTheMarbol();
    }
    
}


//first quick sort
//binary search