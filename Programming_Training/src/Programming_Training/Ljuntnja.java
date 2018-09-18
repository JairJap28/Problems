
package Programming_Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ljuntnja {
    
    public Ljuntnja() throws IOException{
        Scanner sc = new Scanner();
        
        while(sc.hasNext()){
            long m = sc.nextLong();
            long n = sc.nextLong();

            long children[] = new long[(int) n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                children[i] = sc.nextLong();
                sum += children[i];
            }

            Arrays.sort(children);

            int i = (int) n - 1;
            int out = 0;
            
            while(sum > 0 && m > 0){
                if(sum == m){
                    m -= children[i];
                    sum -= children[i];
                }
                else{
                    m -= children[i] - 1;
                    sum -= children[i];
                    children[i] -= children[i] - 1;
                    out += children[i] * children[i];
                }
                i--;
            }
            System.out.println(out);
        }
    }
    
    public static void main(String[] args) throws IOException{
        Ljuntnja obj = new Ljuntnja();
    }
    
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int spaces = 0;
        
        boolean hasNext() throws IOException{
            while(!st.hasMoreTokens()){
                String line = br.readLine();
                if(line == null){
                    return false;
                }
                if(line.equals("")){
                    spaces++;
                }
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
        
        long nextLong() throws IOException{
            return Long.parseLong(next());
        }
    }
}
