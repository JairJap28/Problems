
package CodeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHFINTRO {

    public CHFINTRO() throws IOException {
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int r = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int aux = sc.nextInt();
            if(aux < r){
                System.out.println("Bad boi");
            }
            else{
                System.out.println("Good boi");
            }
        }
        
    }

    public static void main(String[] args) throws IOException {
       new CHFINTRO();
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
