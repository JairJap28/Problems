
package Programming_Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NNodN {
    
    int divisors[] = new int[1000005];
    int serie[] = new int[1000005];
    int middle;
    void generate() {
        int i, j;
        for (i = 0; i <= 1000000; i++) {
            divisors[i] = 1;
        }
        for (i = 2; i <= 1000000; i++) {
            divisors[i] += 1;
            for (j = i + i; j <= 1000000; j = j + i) {
                divisors[j] += 1;
            }
        }
    }
    
    int binary(int arr[], int l, int r, int x){
        int mid = -1;
        if(r >= l){
            middle = mid =  l + (r - l) / 2;
            
            if(arr[mid] == x) return mid;
            if(arr[mid] != x && l == r) return mid;
            if(arr[mid] > x) return binary(arr, l, mid - 1, x);
            return binary(arr, mid + 1, r, x);
        }
        return mid;
    }
    
    void createSerie(){
        serie[0] = 1;
        for(int i = 1; true; i++){
            int aux = serie[i - 1] + divisors[serie[i - 1]];
            if(aux <= 1000000) serie[i] = aux;
            else break;
        }
    }

    public NNodN() throws IOException {
        
        Scanner lea = new Scanner();
        generate();
        createSerie();
        
        int cases = lea.nextInt();
        for (int t = 0; t < cases; t++) {
            int a = lea.nextInt();
            int b = lea.nextInt();

            int posA = binary(serie, 0, 64724, a);
            if(posA == -1) posA = middle;
            int posB = binary(serie, 0, 64724, b);
            if(posB == -1) posB = middle;
            
            if(serie[posA] < a) posA++;
            if(serie[posB] > b) posB--;
            System.out.println("Case " + (t + 1) + ": " + ((posB + 1)  - posA));
        }
    }

    public static void main(String[] args) throws IOException {
        NNodN obj = new NNodN();
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
