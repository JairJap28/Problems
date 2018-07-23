/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeeksForGeeksPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class ShuffleIntegers {

    public ShuffleIntegers() throws IOException {
        Scanner lea = new Scanner();
        
        int cases = lea.nextInt();
        for (int t = 0; t < cases; t++) {
            int n = lea.nextInt();
            int data[] = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = lea.nextInt();
            }
            int dest = 1;
            int pos = n / 2;
            while(pos < n && dest < pos){
                shuffle(data, dest, pos);
                dest += 2;
                pos++;
            }

            for (int i = 0; i < n; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
    }
    
    void shuffle(int arr[], int dest, int pos){
        if(dest == pos) return;
        int tmp = arr[pos - 1];
        arr[pos - 1] = arr[pos];
        arr[pos] = tmp;
        shuffle(arr, dest, pos - 1);
    }
    
    public static void main(String[] args) throws IOException {
        ShuffleIntegers shuffleIntegers = new ShuffleIntegers();
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
