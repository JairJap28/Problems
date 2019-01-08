
package Programming_Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Freckles {
    
    int MAX = 105;
    int N;
    int T;
    double x[] = new double[MAX];
    double y[] = new double[MAX];
    boolean intree[] = new boolean[MAX];
    
    public Freckles() throws IOException {
        Scanner sc = new Scanner();
        int i;
        int j;
        int c;
        int minp = 0;
        double dx;
        double dy;
        double len;
        double min;
        double weight;
        
        T = sc.nextInt();
        for(int cases = 0; cases < T; cases++){
            N = sc.nextInt();
            for(i = 0; i < N; i++){
                intree[i] = false;
            }
            
            for(i = 0; i < N; i++){
                x[i] = sc.nextDouble();
                y[i] = sc.nextDouble();
            }
            
            //Simple Prim algorith
            c = 1;
            intree[0] = true;
            weight = 0;
            
            while(c < N){
                min = -1.0;
                for(i = 0; i < N; i++){
                    if(intree[i]){
                        for(j = 0; j < N; j++){
                            if(!intree[j]){
                                dx = (x[i] - x[j]);
                                dy = (y[i] - y[j]);
                                len = Math.sqrt((dx * dx) + (dy * dy));
                                if(min == -1.0 || len < min){
                                    min = len;
                                    minp = j;
                                }
                            }
                        }
                    }
                }
                
                //Add to MST
                intree[minp] = true;
                weight += min;
                c++;
            }
            
            String out = String.format("%.2f", weight);
            System.out.println(out);
            
            if(cases + 1 < T){
                System.out.println("");
            }
        }
        
    }

    public static void main(String[] args) throws IOException {
        new Freckles();
    }
        
    class Scanner{
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
                    if(st.countTokens() > 0){
                        out.append(" ");
                    }
                }
                return out.toString();
            }
            return br.readLine();
        }
        
        String next() throws IOException{
            spaces = 0;
            while(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
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
        
        int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
        
        float nextFloat() throws IOException{
            return Float.parseFloat(next());
        }
        
        double nextDouble() throws IOException{
            return Double.parseDouble(next());
        }
    }
}
