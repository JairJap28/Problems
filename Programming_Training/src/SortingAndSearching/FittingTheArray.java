
package SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FittingTheArray {

    public FittingTheArray() throws IOException {
        Scanner reader = new Scanner();
        
        int cases = reader.nextInt();
        for (int t = 0; t < cases; t++) {
            int n = reader.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];

            for (int i = 0; i < n; i++) 
                a[i] = reader.nextInt();

            for (int i = 0; i < n; i++) 
                b[i] = reader.nextInt();

            /*quickSort(a, 0, n - 1);
            quickSort(b, 0, n - 1); 0.09  */
            
            mergeSort(a, 0, n - 1);
            mergeSort(b, 0, n - 1); // 0.07
            
            /*Arrays.sort(a);
            Arrays.sort(b); 0.07*/ 

            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if(a[i] > b[i]){
                    flag = false;
                    break;
                } 
            }

            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }
        
    }    
    
    int partition(int arr[], int low, int high){
        int p = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if(arr[j] <= p){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    
    void quickSort(int arr[], int low, int high){
        if(low < high){
            int p = partition(arr, low, high);
            
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }
    
    void swap(int arr[], int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    
    void mergeSort(int a[], int left, int right){
        if(right > left){
            int middle = left + (right - left) / 2;
            
            mergeSort(a, left, middle);
            mergeSort(a, middle + 1, right);
            
            merge(a, left, middle, right);
        }
    }
    
    void merge(int a[], int left, int middle, int right){
        int t1 = middle - left + 1;
        int t2 = right - middle;
        
        int hLeft[] = new int[t1];
        int hright[] = new int[t2];
        
        int j = 0;
        for (int i = left; i <= middle; i++) {
            hLeft[j] = a[i];
            j++;
        }
        
        j = 0;
        for (int i = middle + 1; i <= right; i++) {
            hright[j] = a[i];
            j++;
        }
        
        int i = 0;
        int k = left;
        j = 0;
        
        while(i < t1 && j < t2){
            if(hLeft[i] < hright[j]){
                a[k] = hLeft[i];
                i++;
                k++;
            }
            else{
                a[k] = hright[j];
                j++;
                k++;
            }
        }
        
        for (int l = i; l < t1; l++) {
            a[k] = hLeft[l];
            k++;
        }   
        
        for (int l = j; l < t2; l++) {
            a[k] = hright[l];
            k++;
        }
    }
    
    
    

    public static void main(String[] args) throws IOException {
        new FittingTheArray();
    }
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int spaces = 0;
        
        String nextLine() throws IOException{
            if(spaces > 0){
                spaces--;
                return "";
            }
            else if(st.hasMoreTokens()){
                StringBuilder out = new StringBuilder();
                while(st.hasMoreTokens()){
                    out.append(st.nextToken());
                    if(st.countTokens() > 0) out.append(" ");
                }
                return out.toString();
            }
            return br.readLine();
        }
        
        boolean hasNext() throws IOException{
            while(!st.hasMoreTokens()){
                String line = br.readLine();
                if(line == null) return false;
                if(line.equals("")) spaces++;
                st = new StringTokenizer(line);
            }
            return true;
        }
        
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
