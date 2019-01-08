
package CodeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class TWONMS {

    public TWONMS() throws IOException {
        Scanner sc = new Scanner();
        
        int cases = sc.nextInt();
        
        for(int i = 0; i < cases; i++){
            long a = sc.nextInt();
            long b = sc.nextInt();
            int n = sc.nextInt();
                        
            BigInteger c = BigInteger.valueOf(a);
            BigInteger d = BigInteger.valueOf(b);
            
            if(n % 2 != 0){
                c = c.multiply(BigInteger.valueOf(2));
            }
            
            System.out.println((c.max(d).divide(c.min(d))));
            
        }
    }
    
    public static void main(String[] args) throws IOException {
        new TWONMS();
    }
    
    static class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int spaces = 0;
        
        public String nextLine() throws IOException{
            if(spaces > 0){
                spaces--;
                return "";
            }
            else if(st.hasMoreTokens()){
                StringBuilder out = new StringBuilder();
                while(st.hasMoreTokens()){
                    out.append(st.nextToken());
                    if(st.countTokens() > 0){
                        out.append(" ");
                    }
                }
                return out.toString();
            }
            return br.readLine();
        }
        
        public String next() throws IOException{
            spaces = 0;
            while(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        public boolean hasNext() throws IOException{
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
        
        public int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
        
        public long nextLong() throws IOException{
            return Long.parseLong(next());
        }
        
    }
}
