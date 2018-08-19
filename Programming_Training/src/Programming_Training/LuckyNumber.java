
package Programming_Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LuckyNumber {

    public LuckyNumber() throws IOException {
        Scanner lea = new Scanner();
        
        while(lea.hasNext()){
            int k = lea.nextInt();
        
            int zeros;
            int limit;
            String res;
            String tmp;

            if(k < 7){
                switch(k){
                    case 1: System.out.println("4"); break;
                    case 2: System.out.println("7"); break;
                    case 3: System.out.println("44"); break;
                    case 4: System.out.println("47"); break;
                    case 5: System.out.println("74"); break;
                    case 6: System.out.println("77"); break;
                }
            }
            else{
                zeros = 3;
                limit = 7;
                while(k >= (limit * 2) + 1){
                    limit = limit * 2 + 1;
                    zeros++;
                }
                res = Integer.toBinaryString(k - limit);
                if(limit == k){
                    res = "";
                    for(int i = 0; i < zeros; i++){
                        res += "4";
                    }
                    System.out.println(res);
                }
                else{
                    tmp = "";
                    for(int i = 0; i < (zeros - res.length()); i++){
                        tmp += "4";
                    }

                    res = res.replace('0', '4');
                    res = res.replace('1', '7');
                    System.out.println(tmp + res);
                }
        }
        
        
            
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        LuckyNumber onj = new LuckyNumber();
    }
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int spaces = 0;
        
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
