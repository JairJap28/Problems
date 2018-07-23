/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class PartSort {

    public PartSort() throws IOException {
        
        Scanner lea = new Scanner();
        
        int cases = lea.nextInt();
        
        for (int t = 0; t < cases; t++) {
            int n = lea.nextInt();
            int numbers[] = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = lea.nextInt();
            }

            int a = lea.nextInt();
            int b = lea.nextInt();
            
            if(a > b) mergeSort(numbers, b, a);
            else mergeSort(numbers, a, b);
            
            for (int i = 0; i < n; i++) {
                System.out.print(numbers[i]);
                if(i < n - 1) System.out.print(" ");
            }
            System.out.println("");
        }
    }
    
    void merge(int a[], int left, int middle, int right){
        
        int tam1 = middle - left + 1;
        int tam2 = right - middle;
        
        int hLeft[] = new int[tam1];
        int hRight[] = new int[tam2];
        
        int j = 0;
        for (int i = left; i <= middle; i++) {
            hLeft[j] = a[i];
            j++;
        }
        
        j = 0;
        for (int i = middle + 1; i <= right; i++) {
            hRight[j] = a[i];
            j++;
        }
        
        int i = 0;
        int k = left;
        j = 0;
        
        while(i < tam1 && j < tam2){
            if(hLeft[i] < hRight[j]){
                a[k] = hLeft[i];
                i++;
                k++;
            }
            else{
                a[k] = hRight[j];
                j++;
                k++;
            }
        }
        
        for (int l = i; l < tam1; l++) {
            a[k] = hLeft[l];
            k++;
        }
        
        for (int l = j; l < tam2; l++) {
            a[k] = hRight[l];
            k++;
        }
    }
    
    void mergeSort(int a[], int left, int right){
        if(right > left){
            
            int middle = left + (right - left) / 2;
            
            mergeSort(a, left, middle);
            mergeSort(a, middle + 1, right);
            
            merge(a, left, middle, right);
        }
        
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new PartSort();
    }
    
}
