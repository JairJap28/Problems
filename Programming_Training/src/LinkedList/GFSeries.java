
package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GFSeries {

    public GFSeries() throws IOException {
        Scanner lea = new Scanner();
        
        int cases = lea.nextInt();
        for (int t = 0; t < cases; t++) {
            int n = lea.nextInt();
            long data[] = new long[n];
            if(n >= 1) data[0] = 0;
            if(n >= 2){
                data[1] = 1;
                /*for (int i = 2; i < n; i++) 
                    data[i] = (data[i - 2] * data[i - 2]) - data[i - 1];Execution time: 0.07 */ 
                number(data, 2); //Execution time: 0.08
            }
            for (int i = 0; i < n; i++) 
                System.out.print(data[i] + " ");
            
            System.out.println();
        }
    }
    
    void number(long data[], int i){ //By recursion
        if(i == data.length) return;
        data[i] = (data[i - 2] * data[i - 2]) - data[i - 1];
        number(data, i + 1);
    }
    
    public static void main(String[] args) throws IOException {
        GFSeries gFSeries = new GFSeries();
    }
    
    class Scanner {
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
