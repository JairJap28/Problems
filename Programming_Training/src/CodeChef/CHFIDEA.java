package CodeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHFIDEA {

    public CHFIDEA() {
        Scanner sc = new Scanner();
        
    }
    
    public static void main(String[] args) {
        new CHFIDEA();
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
    }
    
}
