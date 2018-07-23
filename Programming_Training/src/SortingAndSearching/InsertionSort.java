
package SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InsertionSort {

    public InsertionSort() throws IOException {
        Scanner lea = new Scanner();
        
        int n = lea.nextInt();
        int numbers[] = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = lea.nextInt();
        }
        
        insertionSort(numbers, n);
        
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
        }
        
        System.out.println("");
    }
    
    void insertionSort(int arr[], int n){
        int pos;
        for (int i = 1; i < n; i++) {
            pos = i;
            int key = arr[pos];
            try {
                while(key < arr[pos - 1]){
                    arr[pos] = arr[pos - 1];
                    pos--;
                }
                arr[pos + 1] = key;
            } catch (Exception e) {
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        new InsertionSort();
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
