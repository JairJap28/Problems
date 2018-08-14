
package Programming_Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ElectricBill {
    
    int binarySearch(int l, int r, int x){
       
        if(r >= l){
            int middle = (l + r) / 2;
            if(middle == x) return middle;
            if(middle > x) return binarySearch(l, middle - 1, x);
            else return binarySearch(middle + 1, r, x);
        }
        return -1;
    }

    public ElectricBill() throws IOException{
        Scanner lea = new Scanner();
        int a = lea.nextInt();
        int b = lea.nextInt();
        
        System.out.println(binarySearch(0, a, b));
                
    }
    
    public static void main(String[] args) throws IOException {
        ElectricBill obj = new ElectricBill();
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
