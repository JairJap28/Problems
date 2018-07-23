
package SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SelectionSort {

    public SelectionSort() throws IOException {
        Scanner lea = new Scanner();
        
        int cases = lea.nextInt();
        for (int t = 0; t < cases; t++) {
            int n = lea.nextInt();
            int numbers[] = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = lea.nextInt();
            }

            int pos = 0;
            while(pos < n){
                int index = minimunElement(numbers, pos);

                if(index != pos){
                    int tmp = numbers[pos];
                    numbers[pos] = numbers[index];
                    numbers[index] = tmp;
                }

                pos++;
            }

            for (int i = 0; i < n; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println("");
        }
        
        
        
    }
    
    int minimunElement(int a[], int i){
        
        int min = a[i];
        int index = i;
        
        for (int j = i; j < a.length; j++) {
            if(a[j] < min){
                min = a[j];
                index = j;
            }
        }
        
        return index;
    }
    
    

    public static void main(String[] args) throws IOException {
        new SelectionSort();
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
