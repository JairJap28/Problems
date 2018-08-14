package Programming_Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StoneGame {

    public StoneGame() throws IOException{
        Scanner lea = new Scanner();
        
        int n;
        
        while((n = lea.nextInt()) != 0){
            int result = 0;
            for(int i = 0; i < n; i++){
                result ^= lea.nextInt();
            }

            if(result == 0) System.out.println("No");
            else System.out.println("Yes");
        }
        
        
    }
    
    public static void main(String[] args) throws IOException {
        StoneGame obj = new StoneGame();
    }
    
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int spaces = 0;
        
        String next() throws IOException{
            spaces = 0;
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
