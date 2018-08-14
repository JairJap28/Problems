
package Programming_Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PowerCrisis {
    
    public PowerCrisis() throws IOException{
        Scanner lea = new Scanner();
        
        int n;
        while((n = lea.nextInt()) != 0){
            int m = 1;
            while(true){
                boolean[] city = new boolean[n];
                int index = 0;
                int count = 0;

                while(true){
                    city[index] = true;
                    ++count;

                    if(count == n){
                        break;
                    }

                    for (int i = 0; i < m; i++) {
                        ++index;
                        index %= n;

                        if(city[index]){
                            --i;
                        }
                    }
                }

                if(index == 12){
                    System.out.println(m);
                    break;
                }
                ++m;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        PowerCrisis obj = new PowerCrisis();
    }
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        
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
