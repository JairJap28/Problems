
package SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BucketSort {

    public BucketSort() throws IOException {
        Scanner read = new Scanner();
        int n = read.nextInt();
        
        ArrayList<Float> store[] = new ArrayList[n];
        float numbers[] = new float[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = read.nextFloat();
            store[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            int aux = Integer.parseInt(((numbers[i] * 10) + "").charAt(0) + "");
            store[aux].add(numbers[i]);
        }
        
        for (int i = 0; i < n; i++) {
            insertionSort(store[i]);
        }
        
        int i = 0;
        int j = 0;
        
        while(i < n){
            for (int k = 0; k < store[j].size(); k++) {
                numbers[i] = store[j].get(k);
                i++;
            }
            j++;
        }
        
        for (int k = 0; k < n; k++) {
            System.out.print(numbers[k] + " ");
        }
        System.out.println("");
    }
    
    void insertionSort(ArrayList<Float> arr ){
        int pos;
        for (int i = 1; i < arr.size(); i++) {
            pos = i;
            try {
                while(arr.get(pos) < arr.get(pos - 1)){
                    float tmp = arr.get(pos - 1);
                    arr.remove(pos - 1);
                    arr.add(pos, tmp);
                    pos--;
                }
            } catch (Exception e) {
            }
        }
        
    }
    

    public static void main(String[] args) throws IOException {
        new BucketSort();
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
        
        float nextFloat() throws IOException{
            return Float.parseFloat(next());
        }
        
    }
    
}
