
package Programming_Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JokingWithFermatTheorem {

    public JokingWithFermatTheorem() throws IOException {
        Scanner lea = new Scanner();
        int cases = 1;
        while(lea.hasNext()){
            int x = lea.nextInt();
            int y = lea.nextInt();
            int counter = 0;
            int limit = ((int) Math.pow(10, 8))  / 3;
            for (long a = x; a < limit; a++) {
                for (long  b = x; b < limit; b++) {
                    long t = ((a * a * a) + (b * b * b));
                    long c = t / 10;
                    if(t % 10 != 3) continue;
                    if(x <= c && c <= y){
                        counter++;
                    }
                }
            }

            System.out.println("Case " + cases + ": " + counter);
            cases++;
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        new JokingWithFermatTheorem();
    }
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int space = 0;
        
        boolean hasNext() throws IOException{
            while(!st.hasMoreTokens()){
                String line = br.readLine();
                if(line == null) return false;
                if(line.equals("")) space++;
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
