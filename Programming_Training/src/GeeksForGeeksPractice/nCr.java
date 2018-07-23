
package GeeksForGeeksPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class nCr {

    public nCr() throws IOException {
        Scanner lea = new Scanner();
        
        nCr obj = new nCr();
        
        int cases = lea.nextInt();
        for (int t = 0; t < cases; t++) {
            int n = lea.nextInt();
            int r = lea.nextInt();
            System.out.println(obj.combinatorial(n, r));
        }
    }
    
    BigInteger combinatorial(int n, int r){
        BigInteger result = getFactorial(n).divide(getFactorial(r).multiply(getFactorial(n - r)));
        result = result.mod(BigInteger.valueOf(1000000007));
        return result;
    }

    BigInteger getFactorial(int n){
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf((long) i));
        }
        return fact;
    }
    
    public static void main(String[] args) throws IOException {
        nCr obj = new nCr();
    }
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br= new BufferedReader(isr);
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
